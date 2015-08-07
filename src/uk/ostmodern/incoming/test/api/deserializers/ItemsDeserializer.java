package uk.ostmodern.incoming.test.api.deserializers;

import com.google.gson.*;
import uk.ostmodern.incoming.test.api.gson_models.ItemsModel;

import java.lang.reflect.Type;

/**
 * Created by sniper on 2015.
 */
public class ItemsDeserializer implements JsonDeserializer {

    @Override
    public ItemsModel deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final ItemsModel item = new Gson().fromJson(jsonObject, ItemsModel.class);

        return item;
    }
}
