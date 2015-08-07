package uk.ostmodern.incoming.test.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.nostra13.universalimageloader.core.ImageLoader;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.activities.StartActivity;
import uk.ostmodern.incoming.test.api.async.GetEpisodeAsyncTask;
import uk.ostmodern.incoming.test.api.async.GetImageAsyncTask;
import uk.ostmodern.incoming.test.api.gson_models.ItemsModel;
import uk.ostmodern.incoming.test.api.gson_models.ResponseEpisodeModel;
import uk.ostmodern.incoming.test.api.gson_models.ResponseImageModel;
import uk.ostmodern.incoming.test.api.interfaces.ApiModelsInterface;
import uk.ostmodern.incoming.test.api.interfaces.OnResponseListener;
import uk.ostmodern.incoming.test.constants.CallConstants;
import uk.ostmodern.incoming.test.constants.Preferences;
import uk.ostmodern.incoming.test.custom.OstModernCustomTextView;
import uk.ostmodern.incoming.test.enums.ApiRequest;

/**
 * Created by sniper on 2015.
 */
public class EpisodeFragment extends OstModernBaseFragment implements OnResponseListener {

    private ImageView episodeImage;
    private OstModernCustomTextView episodeTitle;
    private ItemsModel selectedEpisodeItem;
    private GetEpisodeAsyncTask episodeAsyncTask;
    private GetImageAsyncTask imageAsyncTask;
    private ResponseEpisodeModel episodeData;
    private ResponseImageModel imageData;

    public EpisodeFragment(){}
    public static EpisodeFragment newInstance(Bundle bundle) {
        EpisodeFragment f = new EpisodeFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectedEpisodeItem = (getArguments().containsKey(Preferences.SELECTED_ITEM_FROM_SET)) ? (ItemsModel) getArguments().getSerializable(Preferences.SELECTED_ITEM_FROM_SET) : new ItemsModel();
        episodeAsyncTask = new GetEpisodeAsyncTask(mActivity,this,selectedEpisodeItem.getContentUrl());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayoutRecourse(R.layout.episode_fragment_layout);
        super.onCreateView(inflater, container, savedInstanceState);
        episodeImage = (ImageView)getRootView().findViewById(R.id.episode_image);
        episodeTitle = (OstModernCustomTextView)getRootView().findViewById(R.id.episode_title);
        if(mActivity.getmApplication().isOnline ) episodeAsyncTask.execute();


        return getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(episodeAsyncTask != null) episodeAsyncTask.cancel(true);
        if(imageAsyncTask != null) imageAsyncTask.cancel(true);
    }

    @Override
    public void onSuccess(ApiModelsInterface model) {
        if(model instanceof ResponseEpisodeModel){
            episodeData = ((ResponseEpisodeModel) model);
            if(mActivity.getmApplication().isOnline && episodeData.getImageUrls() != null) {
//                if we don't have any data to be displayed just load default data
                if(episodeData.getImageUrls().length > 0) {
                    imageAsyncTask = new GetImageAsyncTask(mActivity, this, episodeData.getImageUrls()[0]);
                    imageAsyncTask.execute();
                }else{
                    setDataWithDefaultValues();
                    mActivity.dismissProgressDialog();
                }
            }
        }else if(model instanceof ResponseImageModel){
            imageData = ((ResponseImageModel) model);
            setData();
            mActivity.dismissProgressDialog();
        }
    }

    @Override
    public void onFailure(ApiRequest request, String error) {
        Toast.makeText(mActivity, "Request error : " + error, Toast.LENGTH_SHORT).show();
    }
    private void setData(){
        ImageLoader.getInstance().displayImage(imageData.getUrl(), episodeImage, StartActivity.imageOptions);
        episodeTitle.setText(imageData.getTitle());
    }
    private void setDataWithDefaultValues(){
        ImageLoader.getInstance().displayImage(CallConstants.DEFAULT_IMAGE, episodeImage, StartActivity.imageOptions);
        episodeTitle.setText(getResources().getString(R.string.default_episode_title));
    }
}
