package uk.ostmodern.incoming.test.api.deserializers;

import com.google.gson.*;
import uk.ostmodern.incoming.test.api.gson_models.ResponseSetsModel;
import uk.ostmodern.incoming.test.api.gson_models.SetsModel;
import uk.ostmodern.incoming.test.constants.CallConstants;

import java.lang.reflect.Type;

/**
 * Created by sniper on 2015.
 */
public class ResponseSetsDeserializer implements JsonDeserializer<ResponseSetsModel> {

    @Override
    public ResponseSetsModel deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
//        final boolean isSuccess = jsonObject.get(CallConstants.SUCCESS).getAsBoolean();
//        final String error = jsonObject.get(CallConstants.ERROR).getAsString();

//        // Delegate the deserialization to the context
//        JsonArray responseDataArray = jsonObject.get(CallConstants.RESPONSE_DATA).getAsJsonArray();
        final SetsModel[] allSets = context.deserialize(jsonObject.getAsJsonArray(CallConstants.RESPONSE_DATA), SetsModel[].class);

        final ResponseSetsModel allData = new ResponseSetsModel();
        final boolean isSuccess = (allSets != null && allSets.length > 0);

//        allData.setError(error);
        allData.setSuccess(isSuccess);
        allData.setAllSets(allSets);

        return allData;
    }
}
