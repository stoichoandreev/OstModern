package uk.ostmodern.incoming.test.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import org.json.JSONObject;
import uk.ostmodern.incoming.test.OstModernIncomeApplication;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.constants.CallConstants;
import uk.ostmodern.incoming.test.data.DataHolder;
import uk.ostmodern.incoming.test.enums.ApiRequest;
import uk.ostmodern.incoming.test.fragments.OstModernBaseFragment;
import uk.ostmodern.incoming.test.interfaces.IConnectivityChangeListener;
import uk.ostmodern.incoming.test.receivers.ConnectivityChangeBroadcastReceiver;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sniper on 2015.
 */
public class OstModernBaseActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener,IConnectivityChangeListener {

    private ConnectivityChangeBroadcastReceiver mReceiver;// internet connection checker
    protected ProgressDialog progressDialog;
    protected OstModernIncomeApplication mApplication;
    private int layoutResource;
    private boolean doesApplicationIsNotifiedForInternetConnection;
    List<WeakReference<OstModernBaseFragment>> fragList;//list with all attached fragments in this activity

    public static DisplayImageOptions imageOptions;
    private static ImageLoaderConfiguration imageConfiguration;
    protected static ImageLoader mImageLoader;
    protected DataHolder dataHolder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResource);
        mApplication = (OstModernIncomeApplication) getApplication();
        dataHolder = new DataHolder();
        fragList = new ArrayList<WeakReference<OstModernBaseFragment>>();

        imageConfiguration = new ImageLoaderConfiguration.Builder(this)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(200 * 1024 * 1024) // 200 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .build();
        mImageLoader = ImageLoader.getInstance();
        mImageLoader.init(imageConfiguration);
        imageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(getImageLoaderDefaultImage())
                .showImageForEmptyUri(getImageLoaderDefaultImage())
                .showImageOnFail(getImageLoaderDefaultImage())
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .build();

        getFragmentManager().addOnBackStackChangedListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            if(mReceiver != null){
                unregisterReceiver(mReceiver);
            }
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }
    }
    public void addFragment(Fragment fragment,boolean withAnimationTransaction) {
        FragmentTransaction t = getFragmentManager().beginTransaction();
        if(withAnimationTransaction) t.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);

        String fragmentClassName = ((Object) fragment).getClass().getSimpleName();
        t.replace(R.id.activity_fragment_container, fragment, fragmentClassName);
//        t.replace(fragmentCont.getId(), fragment, fragmentClassName);
        t.addToBackStack(fragmentClassName);
        t.commit();
    }

    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() <= 2) {
            getFragmentManager().popBackStackImmediate();
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStackImmediate();
        }
    }
    public void showSoftKeyBoard(View view) {
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public void hideSoftKeyBoard(View view) {
//        Pass view which is on focus with keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    @Override
    public void onAttachFragment (Fragment fragment) {
        fragList.add(new WeakReference(fragment));
    }

    public void shouldDisplayHomeUp() { }
//  Should be used in oldest Android API
//    @Override
//    public boolean onSupportNavigateUp() {
//        //This method is called when the up button is pressed. Just the pop back stack.
//        getFragmentManager().popBackStack();
//        return true;
//    }

    @Override
    public boolean onNavigateUp() {
        if (getFragmentManager().getBackStackEntryCount() > 1 ) {
            onBackPressed();
            return true;
        } else return super.onNavigateUp();
    }

    protected void setLayoutResource(int resource){
        this.layoutResource = resource;
    }

    public ProgressDialog getProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(getString(R.string.loading));
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        return progressDialog;
    }
    @Override
    public void connectivityChange(boolean connected) {
        mApplication.isOnline = connected;
        informFragmentsAboutInternetStateChange(connected);
        if(connected && !doesApplicationIsNotifiedForInternetConnection){
            doesApplicationIsNotifiedForInternetConnection = true;
            applicationHasInternetConnection();
        }else {
            doesApplicationIsNotifiedForInternetConnection = false;
        }
    }
    public String getRequestUrl(ApiRequest request){
        switch (request){
            case WELCOME:
                return CallConstants.API_URL;
            case SETS:
                return CallConstants.SKYLARK_SETS;
            case EPISODES:
                return CallConstants.SKYLARK_EPISODES;
            default:
                return CallConstants.API_URL;
        }
    }
    public JSONObject getRequestParameters(ApiRequest apiRequest){
        JSONObject mainObject = new JSONObject();
        JSONObject session = new JSONObject();
        JSONObject data = new JSONObject();

//        Pass some parameters for current request

//        try {
//            session.put(CallConstants.AUTHENTICATION_HASH,mApplication.getToken());
//            session.put(CallConstants.DEVICE_IDENTIFIER,mApplication.getDeviceId());
//
//            data.put(CallConstants.EMAIL,mApplication.getEmail());
//
//            mainObject.put(CallConstants.SESSION,session);
//            mainObject.put(CallConstants.DATA,data);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        return mainObject;
    }
    protected void applicationHasInternetConnection(){}

    private int getImageLoaderDefaultImage(){ return R.drawable.products_img_background;}

    public DataHolder getDataHolder(){return  dataHolder;}

    public OstModernIncomeApplication getmApplication(){return mApplication;}

    public void registerInternetReceiver(){
        if (mReceiver == null) {
            mReceiver = new ConnectivityChangeBroadcastReceiver(this);
        }
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mReceiver, filter);
    }
    private void informFragmentsAboutInternetStateChange(boolean connected){
        for(WeakReference<OstModernBaseFragment> ref : fragList) {
            OstModernBaseFragment f = ref.get();
            if(f != null) {
                f.onInternetStateChange(connected);
            }
        }
    }
    public void dismissProgressDialog(){
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}