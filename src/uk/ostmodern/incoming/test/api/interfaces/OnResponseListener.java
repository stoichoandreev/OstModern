package uk.ostmodern.incoming.test.api.interfaces;


import uk.ostmodern.incoming.test.enums.ApiRequest;

/**
 * Created by sniper on 2015.
 */
public interface OnResponseListener {
    void onSuccess(ApiModelsInterface model);
    void onFailure(ApiRequest request, String error);
}
