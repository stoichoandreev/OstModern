package uk.ostmodern.incoming.test.constants;

/**
 * Created by sniper on 2015.
 */
public class CallConstants {

    public static final String BASE_URL = "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000";
    public static final String API_URL = "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/api/";
    public static final String SKYLARK_SETS = (API_URL +"sets/");
    public static final String SKYLARK_EPISODES = (API_URL +"episodes/");

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String RESPONSE_DATA = "objects";
    public static final String APP_KEY = "app_key";

    //Sets Request
    public static final String UID = "uid";
    public static final String SHEDULE_URLS = "schedule_urls";
    public static final String SHEDULE_URL = "schedule_url";
    public static final String PUBLISH_ON = "publish_on";
    public static final String QUOTER = "quoter";
    public static final String FEATURED = "featured";
    public static final String LANGUAGE_MODIFIED_BY = "language_modified_by";
    public static final String PLANS = "plans";
    public static final String CASHED_FILM_COUNT = "cached_film_count";
    public static final String MODIFIED_BY = "modified_by";
    public static final String TEMP_ID = "temp_id";
    public static final String TITLE = "title";
    public static final String SELF = "self";
    public static final String CREATED_BY = "created_by";
    public static final String LANGUAGE_PUBLISH_ON = "language_publish_on";
    public static final String LANGUAGE_MODIFIED = "language_modified";
    public static final String HAS_PRICE = "has_price";
    public static final String SET_TYPE_URL = "set_type_url";
    public static final String TEMP_IMAGE = "temp_image";
    public static final String FILM_COUNT = "film_count";
    public static final String BODY = "body";
    public static final String LANGUAGE_VERSION_URL = "language_version_url";
    public static final String QUOTE = "quote";
    public static final String LOWEST_AMOUNT = "lowest_amount";
    public static final String FORMATTED_BODY = "formatted_body";
    public static final String IMAGE_URLS = "image_urls";
    public static final String HIERARCHY_URL = "hierarchy_url";
    public static final String ACTIVE = "active";
    public static final String SLUG = "slug";
    public static final String VERSION_NUMBER = "version_number";
    public static final String LANGUAGE_ENDS_ON = "language_ends_on";
    public static final String CREATED = "created";
    public static final String ITEMS = "items";
    public static final String LANGUAGE_VERSION_NUMBER = "language_version_number";
    public static final String MODIFIED = "modified";
    public static final String SUMMARY = "summary";
    public static final String ENDS_ON = "ends_on";
    public static final String VERSION_URL = "version_url";
    public static final String SET_TYPE_SLUG = "set_type_slug";

    public static final String LINK_URL = "link_url";
    public static final String SUB_HEADING = "sub_heading";
    public static final String LINK_TITLE = "link_title";
    public static final String CONTENT_URL = "content_url";
    public static final String SET_URL = "set_url";
    public static final String CONTENT_TYPE = "content_type";
    public static final String POSITION = "position";
    public static final String HEADING = "heading";
    public static final String URL = "url";

//    Episode request API
    public static final String SUBTITLE = "subtitle";
    public static final String TALENT_URLS = "talent_urls";
    public static final String PLAN_URLS = "plan_urls";
    public static final String EPISODE_NUMBER = "episode_number";
    public static final String TAG_URLS = "tag_urls";
    public static final String SYNOPSIS = "synopsis";
    public static final String PARENT_URL = "parent_url";

//    Image request Api
    public static final String SHOW = "show";
    public static final String IMAGE_TYPE_URL = "image_type_url";
    public static final String UPLOAD_IMAGE_URL = "upload_image_url";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE_TYPE = "image_type";
    public static final String ALIGN = "align";

    public static final String DEFAULT_IMAGE = "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/static/images/dummy/dummy-film.jpg";


    public static String getApiUrl(String contentUrl){
        return (BASE_URL+contentUrl);
    }


}
