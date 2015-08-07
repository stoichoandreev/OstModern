package uk.ostmodern.incoming.test.constants;

/**
 * Created by sniper on 2/21/15.
 */
public class Preferences {
    public static final String SHARED_PREFS_FILE_NAME = "ost_modern_preferences";
    public static final String SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String APPLICATION_DATE_FORMAT = "MMM d, yyyy";
//    public static final String APPLICATION_AUTHENTICATE = "is_authenticate";
//    public static final String APPLICATION_TOKEN = "app_token";
//    public static final String APPLICATION_DEVICE_ID = "app_device_id";
    public static final String APPLICATION_LANGUAGE = "app_language";

//    public static final String IMAGE_PATH = "image_path";
//    public static final int IMAGE_QUALITY = 80;

    //Bundle Constants
    public static final String BUNDLE_CONST = "bundle_const";
    public static final String VIEW_PAGER_FRAGMENT_DATA_MODEL = "pager_fragment_data_model";
    public static final int VIEW_PAGER_ITEMS_NUMBER = 7;// must be 5,7,9,11,13 ... etc.
    public static final int VIEW_PAGER_HALF_ITEMS = 3;  // must be 2,3,4,5,6 ... etc. //it is ((VIEW_PAGER_ITEMS_NUMBER/2) - 0.5)

    public static final String SELECTED_SET_ITEM = "selected_set_item";
    public static final String SELECTED_ITEM_FROM_SET = "selected_item_from_set";

    public static final String DB_IMAGES_DELIMITER = "&&";

}
