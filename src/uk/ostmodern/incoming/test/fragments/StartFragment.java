package uk.ostmodern.incoming.test.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.api.async.GetImageAsyncTask;
import uk.ostmodern.incoming.test.api.async.GetSetsAsyncTask;
import uk.ostmodern.incoming.test.api.gson_models.ResponseImageModel;
import uk.ostmodern.incoming.test.api.gson_models.ResponseSetsModel;
import uk.ostmodern.incoming.test.api.gson_models.SetsModel;
import uk.ostmodern.incoming.test.api.interfaces.ApiModelsInterface;
import uk.ostmodern.incoming.test.api.interfaces.OnResponseListener;
import uk.ostmodern.incoming.test.constants.CallConstants;
import uk.ostmodern.incoming.test.enums.ApiRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sniper on 2015.
 */
public class StartFragment extends OstModernBaseFragment implements View.OnClickListener,View.OnTouchListener, OnResponseListener {

    private static final int BUTTONS_NUMBER = 2;
    private List<LinearLayout> buttons;
    private List<RelativeLayout> buttonsTextContainers;
    private GetSetsAsyncTask setAsyncTask;
    private HashMap<String, ResponseImageModel> allImages;

    private int imageCounter;//counter to understand when all images are here

    public StartFragment(){}
    public static StartFragment newInstance(Bundle bundle) {
        StartFragment f = new StartFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity.registerInternetReceiver();
        buttons = new ArrayList<LinearLayout>(BUTTONS_NUMBER);
        buttonsTextContainers = new ArrayList<RelativeLayout>(BUTTONS_NUMBER);
        allImages = new HashMap<String, ResponseImageModel>();
        resetMainAsyncTask();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayoutRecourse(R.layout.start_fragment_layout);
        super.onCreateView(inflater, container, savedInstanceState);
        getSetsData();
//        if we already has some data in out lists just clear them
        if(buttons.size() > 0){
            buttons.clear();
            buttonsTextContainers.clear();
        }
        buttons.add((LinearLayout) getRootView().findViewById(R.id.first_button));
        buttons.add((LinearLayout)getRootView().findViewById(R.id.second_button));
        buttonsTextContainers.add((RelativeLayout)getRootView().findViewById(R.id.first_button_text_container));
        buttonsTextContainers.add((RelativeLayout) getRootView().findViewById(R.id.second_button_text_container));
        for(LinearLayout button : buttons){
            button.setOnClickListener(this);
            button.setOnTouchListener(this);
        }

        return getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        OstModernBaseFragment fragment = null;
        switch (v.getId()) {
            case R.id.first_button:
//                fragment = DetailsFragment.newInstance(null);
                fragment = CardViewFragment.newInstance(null);
                break;
            case R.id.second_button:
                fragment = GridViewFragment.newInstance(null);
                break;
        }
        if(fragment != null){
            mActivity.addFragment(fragment,true);
        }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                buttonsTextContainers.get(getPressedItemIndex(v.getId())).setBackgroundColor(getResources().getColor(R.color.buttons_color_down));
                break;
            case MotionEvent.ACTION_UP:
                buttonsTextContainers.get(getPressedItemIndex(v.getId())).setBackgroundColor(getResources().getColor(R.color.buttons_color));
                break;
        }
        return false;
    }
    private int getPressedItemIndex(int id){
        switch (id){
            case R.id.first_button:
                return 0;
            case R.id.second_button:
                return 1;
            default:
                return 0;
        }
    }
    @Override
    public void onDestroy() {
        cancelAsyncTask();
        super.onDestroy();
    }
    @Override
    public void onSuccess(ApiModelsInterface model) {
        if(model instanceof ResponseSetsModel){
            mActivity.getDataHolder().setSets((ResponseSetsModel) model);
            startGettingAllImages();
//            Toast.makeText(this, "All sets data has been loaded successful : ", Toast.LENGTH_SHORT).show();
        }else if(model instanceof ResponseImageModel){
            imageCounter++;
            ResponseImageModel mod = (ResponseImageModel) model;
            allImages.put(mod.getImageKey(),mod);
            if(imageCounter == mActivity.getDataHolder().getSets().getAllSets().length){
                mActivity.getDataHolder().setImagesDictionary(allImages);
                if(mActivity.getProgressDialog().isShowing()) mActivity.getProgressDialog().hide();
            }
        }
    }

    @Override
    public void onFailure(ApiRequest request, String error){
        Toast.makeText(mActivity, "Request error : " + error, Toast.LENGTH_SHORT).show();
//        if there has a problem with request code we set request satic field isRequestExecutedOnes flag to false and try execute request again automatically
        if(request.equals(ApiRequest.SETS)) {
            GetSetsAsyncTask.isRequestExecutedOnes = false;
        }
    }
    //method reset all async tasks flags
    private void resetMainAsyncTask(){
        GetSetsAsyncTask.isRequestExecutedOnes = false;
    }
    private void startGettingAllImages(){
        for(SetsModel setModel : mActivity.getDataHolder().getSets().getAllSets()){
            if(setModel.getImageUrls() != null && setModel.getImageUrls().length > 0){
                new GetImageAsyncTask(mActivity,this,setModel.getImageUrls()[0],setModel.getuId()).execute();
            }else{
//                just create new image model with default image because there isn't image for current set
                ResponseImageModel imageModel = new ResponseImageModel();
                imageModel.setUrl(CallConstants.DEFAULT_IMAGE);
                allImages.put(setModel.getuId(),imageModel);
                imageCounter++;
            }
        }
    }
    private void getSetsData(){
        if(!GetSetsAsyncTask.isRequestExecutedOnes && mActivity.getmApplication().isOnline) {
            setAsyncTask = new GetSetsAsyncTask(mActivity, this);
            setAsyncTask.execute();
        }
    }
    private void cancelAsyncTask(){
        if(setAsyncTask != null) setAsyncTask.cancel(true);
    }
    @Override
    public void onInternetStateChange(boolean isConnected) {
        super.onInternetStateChange(isConnected);
        if(isConnected) {
            getSetsData();
        }else{
            cancelAsyncTask();
        }
    }
}
