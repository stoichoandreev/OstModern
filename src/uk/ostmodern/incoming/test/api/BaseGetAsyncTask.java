package uk.ostmodern.incoming.test.api;

import android.os.AsyncTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import uk.ostmodern.incoming.test.activities.OstModernBaseActivity;
import uk.ostmodern.incoming.test.api.interfaces.OnResponseListener;
import uk.ostmodern.incoming.test.constants.CallConstants;
import uk.ostmodern.incoming.test.enums.ApiRequest;

import java.io.IOException;

/**
 * Created by sniper on 2015.
 */
public class BaseGetAsyncTask extends AsyncTask<String, String, Boolean> {
    protected ResponseBaseModel model;
    protected OnResponseListener listener;
    protected OstModernBaseActivity mActivity;
    private ApiRequest apiBaseRequest;
    private String contentUrl;

    public BaseGetAsyncTask(){}
    public BaseGetAsyncTask(OstModernBaseActivity mActivity, OnResponseListener listener){
        this.mActivity = mActivity;
        this.listener = listener;
    }

    protected void parseJsonAnswer(JSONObject respo){}

    @Override
    protected void onPreExecute() {//block UI
        super.onPreExecute();
    }
    @Override
    protected Boolean doInBackground(String... params) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(
                                        apiBaseRequest.equals(ApiRequest.NONE) ?
                                                contentUrl :
                                                mActivity.getRequestUrl(apiBaseRequest));
            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httpGet);

            JSONObject respo;
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String entityAsString = EntityUtils.toString(entity);
                respo = new JSONObject(entityAsString);
                if (respo != null ) {
//                if (respo != null && respo.has(CallConstants.RESPONSE_DATA)) {
//                if (respo != null && respo.has(CallConstants.SUCCESS)) {

//                We Override  parseJsonAnswer(response) method in all AsyncTasks
                    parseJsonAnswer(respo);

                    return model.isSuccess();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
//        if(mActivity.getProgressDialog().isShowing()){
//            mActivity.getProgressDialog().dismiss();
//        }

        if (listener != null) {
            if (result) {
                listener.onSuccess(model);
            } else if(model != null){
                listener.onFailure(apiBaseRequest,model.getError());
            }
        }
    }

    protected void setApiBaseRequest(ApiRequest apiBaseRequest){this.apiBaseRequest = apiBaseRequest;}
    protected void setContentUrl(String contentUrl){
        this.contentUrl = CallConstants.getApiUrl(contentUrl);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        if(mActivity.getProgressDialog().isShowing()){
            mActivity.getProgressDialog().dismiss();
        }
    }
}