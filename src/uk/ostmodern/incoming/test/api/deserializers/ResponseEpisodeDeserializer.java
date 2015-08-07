package uk.ostmodern.incoming.test.api.deserializers;

import com.google.gson.*;
import uk.ostmodern.incoming.test.api.gson_models.ResponseEpisodeModel;

import java.lang.reflect.Type;

/**
 * Created by sniper on 2015.
 */
public class ResponseEpisodeDeserializer implements JsonDeserializer<ResponseEpisodeModel> {

    @Override
    public ResponseEpisodeModel deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        final ResponseEpisodeModel episode = new Gson().fromJson(jsonObject, ResponseEpisodeModel.class);

        final boolean isSuccess = (episode != null && episode.getuId().length() > 0);

//        allData.setError(error);
        episode.setSuccess(isSuccess);

        return episode;
    }
}
