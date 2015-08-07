package uk.ostmodern.incoming.test.api;

import com.google.gson.annotations.SerializedName;
import uk.ostmodern.incoming.test.api.interfaces.ApiModelsInterface;
import uk.ostmodern.incoming.test.constants.CallConstants;

/**
 * Created by sniper on 2015.
 */
public class ResponseBaseModel implements ApiModelsInterface {
    @SerializedName(CallConstants.SUCCESS)
    private boolean success;
    @SerializedName(CallConstants.ERROR)
    private String error;
    @SerializedName(CallConstants.RESPONSE_DATA)
    private String responseData;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
