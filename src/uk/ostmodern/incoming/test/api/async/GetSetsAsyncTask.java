package uk.ostmodern.incoming.test.api.async;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import uk.ostmodern.incoming.test.activities.OstModernBaseActivity;
import uk.ostmodern.incoming.test.api.BaseGetAsyncTask;
import uk.ostmodern.incoming.test.api.deserializers.ItemsDeserializer;
import uk.ostmodern.incoming.test.api.deserializers.ResponseSetsDeserializer;
import uk.ostmodern.incoming.test.api.deserializers.SetsDeserializer;
import uk.ostmodern.incoming.test.api.gson_models.ItemsModel;
import uk.ostmodern.incoming.test.api.gson_models.ResponseSetsModel;
import uk.ostmodern.incoming.test.api.gson_models.SetsModel;
import uk.ostmodern.incoming.test.api.interfaces.OnResponseListener;
import uk.ostmodern.incoming.test.enums.ApiRequest;

/**
 * Created by sniper on 2015.
 */
public class GetSetsAsyncTask extends BaseGetAsyncTask {

    public static boolean isRequestExecutedOnes;

    public GetSetsAsyncTask(){}
    public GetSetsAsyncTask(OstModernBaseActivity mActivity, OnResponseListener listener){
        super(mActivity, listener);
        isRequestExecutedOnes = false;
        setApiBaseRequest(ApiRequest.SETS);
    }
    @Override
    protected void onPreExecute() {//block UI
        super.onPreExecute();
        isRequestExecutedOnes = true;
        mActivity.getProgressDialog().show();
    }
    @Override
    protected void parseJsonAnswer(JSONObject respo) {

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ResponseSetsModel.class, new ResponseSetsDeserializer());
        gsonBuilder.registerTypeAdapter(SetsModel.class, new SetsDeserializer());
        gsonBuilder.registerTypeAdapter(ItemsModel.class, new ItemsDeserializer());
        final Gson gson = gsonBuilder.create();

        model = gson.fromJson(respo.toString(), ResponseSetsModel.class);
    }
}