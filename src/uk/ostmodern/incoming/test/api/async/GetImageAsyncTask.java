package uk.ostmodern.incoming.test.api.async;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import uk.ostmodern.incoming.test.activities.OstModernBaseActivity;
import uk.ostmodern.incoming.test.api.BaseGetAsyncTask;
import uk.ostmodern.incoming.test.api.deserializers.ResponseImageDeserializer;
import uk.ostmodern.incoming.test.api.gson_models.ResponseImageModel;
import uk.ostmodern.incoming.test.api.interfaces.OnResponseListener;
import uk.ostmodern.incoming.test.enums.ApiRequest;

/**
 * Created by sniper on 2015.
 */
public class GetImageAsyncTask extends BaseGetAsyncTask {

    private String imageKey;//we need image key to set it in DataHolder images dictionary

    public GetImageAsyncTask(){}

    public GetImageAsyncTask(OstModernBaseActivity mActivity, OnResponseListener listener, String imageUrl){
        super(mActivity, listener);
        imageKey = imageUrl;
        setApiBaseRequest(ApiRequest.NONE);
        setContentUrl(imageUrl);
    }
    public GetImageAsyncTask(OstModernBaseActivity mActivity, OnResponseListener listener, String imageUrl,String imageKey){
        super(mActivity, listener);
        this.imageKey = imageKey;
        setApiBaseRequest(ApiRequest.NONE);
        setContentUrl(imageUrl);
    }

    @Override
    protected void onPreExecute() {//block UI
        super.onPreExecute();
        if(!mActivity.getProgressDialog().isShowing()){
            mActivity.getProgressDialog().show();
        }
    }
    @Override
    protected void parseJsonAnswer(JSONObject respo) {

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ResponseImageModel.class, new ResponseImageDeserializer());
        final Gson gson = gsonBuilder.create();

        model = gson.fromJson(respo.toString(), ResponseImageModel.class);
        if(imageKey != null) ((ResponseImageModel)model).setImageKey(imageKey);
    }
}