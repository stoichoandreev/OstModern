package uk.ostmodern.incoming.test.api.gson_models;

import com.google.gson.annotations.SerializedName;
import uk.ostmodern.incoming.test.api.ResponseBaseModel;
import uk.ostmodern.incoming.test.api.interfaces.ApiModelsInterface;
import uk.ostmodern.incoming.test.constants.CallConstants;

/**
 * Created by sniper on 2015.
 */
public class ResponseSetsModel extends ResponseBaseModel implements ApiModelsInterface {
    @SerializedName(CallConstants.RESPONSE_DATA)
    private SetsModel allSets[];

    public SetsModel[] getAllSets() {
        return allSets;
    }

    public void setAllSets(SetsModel[] allSets) {
        this.allSets = allSets;
    }
}
