package uk.ostmodern.incoming.test.api.async;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import uk.ostmodern.incoming.test.activities.OstModernBaseActivity;
import uk.ostmodern.incoming.test.api.BaseGetAsyncTask;
import uk.ostmodern.incoming.test.api.deserializers.ResponseEpisodeDeserializer;
import uk.ostmodern.incoming.test.api.gson_models.ResponseEpisodeModel;
import uk.ostmodern.incoming.test.api.interfaces.OnResponseListener;
import uk.ostmodern.incoming.test.enums.ApiRequest;

/**
 * Created by sniper on 2015.
 */
public class GetEpisodeAsyncTask extends BaseGetAsyncTask {


    public GetEpisodeAsyncTask(){}
    public GetEpisodeAsyncTask(OstModernBaseActivity mActivity, OnResponseListener listener,String episodeContentUrl){
        super(mActivity, listener);
        setApiBaseRequest(ApiRequest.NONE);
        setContentUrl(episodeContentUrl);
    }
    @Override
    protected void onPreExecute() {//block UI
        super.onPreExecute();
        mActivity.getProgressDialog().show();
    }
    @Override
    protected void parseJsonAnswer(JSONObject respo) {

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ResponseEpisodeModel.class, new ResponseEpisodeDeserializer());
        final Gson gson = gsonBuilder.create();

        model = gson.fromJson(respo.toString(), ResponseEpisodeModel.class);
    }
}