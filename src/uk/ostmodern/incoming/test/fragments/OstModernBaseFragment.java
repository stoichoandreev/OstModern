package uk.ostmodern.incoming.test.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.activities.OstModernBaseActivity;
import uk.ostmodern.incoming.test.custom.OstModernCustomButton;
import uk.ostmodern.incoming.test.custom.OstModernCustomTextView;

/**
 * Created by sniper on 2015.
 */
public class OstModernBaseFragment extends Fragment {
    private View rootView;
    private int mLayoutRecourse;
    protected OstModernBaseActivity mActivity;
    protected DisplayImageOptions mImageOptions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (OstModernBaseActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(mLayoutRecourse, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragmentUI();
    }

    @Override
    public void onResume() {
        super.onResume();
        mActivity.hideSoftKeyBoard(rootView);
    }
    public void setLayoutRecourse(int res) {
        mLayoutRecourse = res;
    }

    public View getRootView() {
        return rootView;
    }
    protected void initFragmentUI(){};

    protected void setFragmentTexts(boolean isLanguageChanged){}

    protected void prepareImageOption(int defaultImage){
        if(mImageOptions == null) {
            mImageOptions = new DisplayImageOptions.Builder()
                    .showImageOnLoading(defaultImage)
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnFail(defaultImage)
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .considerExifParams(true)
                    .build();
        }
    }
    protected void showDialog(String title,String subTitle,String buttonText){
        final Dialog dialog = new Dialog(mActivity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout);
        OstModernCustomTextView dialogTitle = (OstModernCustomTextView) dialog.findViewById(R.id.dialog_title);
        OstModernCustomTextView text = (OstModernCustomTextView) dialog.findViewById(R.id.dialog_text);
        OstModernCustomButton dismissButton = (OstModernCustomButton) dialog.findViewById(R.id.dialog_dismiss_button);
        dialogTitle.setText(title);
        text.setText(subTitle);
        dismissButton.setText(buttonText);
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void onInternetStateChange(boolean isConnected){};
}
