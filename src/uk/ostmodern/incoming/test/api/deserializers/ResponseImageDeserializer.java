package uk.ostmodern.incoming.test.api.deserializers;

import com.google.gson.*;
import uk.ostmodern.incoming.test.api.gson_models.ResponseImageModel;

import java.lang.reflect.Type;

/**
 * Created by sniper on 2015.
 */
public class ResponseImageDeserializer implements JsonDeserializer<ResponseImageModel> {

    @Override
    public ResponseImageModel deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        final ResponseImageModel image = new Gson().fromJson(jsonObject, ResponseImageModel.class);

        final boolean isSuccess = (image != null && image.getuId().length() > 0);

//        allData.setError(error);
        image.setSuccess(isSuccess);

        return image;
    }
}
