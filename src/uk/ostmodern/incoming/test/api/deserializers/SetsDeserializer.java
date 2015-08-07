package uk.ostmodern.incoming.test.api.deserializers;

import com.google.gson.*;
import uk.ostmodern.incoming.test.api.gson_models.SetsModel;

import java.lang.reflect.Type;

/**
 * Created by sniper on 2015.
 */
public class SetsDeserializer implements JsonDeserializer<SetsModel> {

    @Override
    public SetsModel deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final SetsModel singleSet = new Gson().fromJson(jsonObject, SetsModel.class);

        return singleSet;
    }
}
