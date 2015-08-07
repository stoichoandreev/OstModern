package uk.ostmodern.incoming.test.data;

import uk.ostmodern.incoming.test.api.gson_models.ResponseImageModel;
import uk.ostmodern.incoming.test.api.gson_models.ResponseSetsModel;

import java.util.HashMap;

/**
 * Created by sniper on 2015.
 */
public class DataHolder {
    private ResponseSetsModel sets;//Object hold parsed set response
    private HashMap<String, ResponseImageModel> imagesDictionary;//hold all sets images dictionary

    public ResponseSetsModel getSets() {
        return sets;
    }
    public void setSets(ResponseSetsModel sets) {
        this.sets = sets;
    }

    public HashMap<String, ResponseImageModel> getImagesDictionary() {
        return imagesDictionary;
    }

    public void setImagesDictionary(HashMap<String, ResponseImageModel> imagesDictionary) {
        this.imagesDictionary = imagesDictionary;
    }
}
