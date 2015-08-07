package uk.ostmodern.incoming.test.api.gson_models;

import com.google.gson.annotations.SerializedName;
import uk.ostmodern.incoming.test.api.ResponseBaseModel;
import uk.ostmodern.incoming.test.api.interfaces.ApiModelsInterface;
import uk.ostmodern.incoming.test.constants.CallConstants;

/**
 * Created by sniper on 8/15/15.
 */
public class SetsModel extends ResponseBaseModel implements ApiModelsInterface {
    @SerializedName(CallConstants.UID)
    private String uId;
    @SerializedName(CallConstants.SHEDULE_URLS)
    private String[] sheduleUrls;
    @SerializedName(CallConstants.PUBLISH_ON)
    private String publishOn;
    @SerializedName(CallConstants.QUOTER)
    private String quoter;
    @SerializedName(CallConstants.FEATURED)
    private boolean featured;
    @SerializedName(CallConstants.LANGUAGE_MODIFIED_BY)
    private String languageModifiedBy;
    @SerializedName(CallConstants.PLANS)
    private String[] plans;
    @SerializedName(CallConstants.CASHED_FILM_COUNT)
    private int cashedFilmCount;
    @SerializedName(CallConstants.MODIFIED_BY)
    private String modifiedBy;
    @SerializedName(CallConstants.LANGUAGE_PUBLISH_ON)
    private String languagePublishOn;
    @SerializedName(CallConstants.TEMP_ID)
    private int tempId;
    @SerializedName(CallConstants.TITLE)
    private String title;
    @SerializedName(CallConstants.SELF)
    private String self;
    @SerializedName(CallConstants.CREATED_BY)
    private String createdBy;
    @SerializedName(CallConstants.LANGUAGE_MODIFIED)
    private String languageModified;
    @SerializedName(CallConstants.HAS_PRICE)
    private boolean hasPrice;
    @SerializedName(CallConstants.SET_TYPE_URL)
    private String setTypeUrl;
    @SerializedName(CallConstants.TEMP_IMAGE)
    private String tempImage;
    @SerializedName(CallConstants.FILM_COUNT)
    private int filmCount;
    @SerializedName(CallConstants.BODY)
    private String body;
    @SerializedName(CallConstants.LANGUAGE_VERSION_URL)
    private String languageVersionUrl;
    @SerializedName(CallConstants.QUOTE)
    private String quote;
    @SerializedName(CallConstants.LOWEST_AMOUNT)
    private String lowestAmount;
    @SerializedName(CallConstants.FORMATTED_BODY)
    private String formattedBody;
    @SerializedName(CallConstants.IMAGE_URLS)
    private String[] imageUrls;
    @SerializedName(CallConstants.HIERARCHY_URL)
    private String hierarchyUrl;
    @SerializedName(CallConstants.SHEDULE_URL)
    private String sheduleUrl;
    @SerializedName(CallConstants.ACTIVE)
    private boolean active;
    @SerializedName(CallConstants.SLUG)
    private String slug;
    @SerializedName(CallConstants.VERSION_NUMBER)
    private int versionNumber;
    @SerializedName(CallConstants.LANGUAGE_ENDS_ON)
    private String languageEndsOn;
    @SerializedName(CallConstants.CREATED)
    private String created;
    @SerializedName(CallConstants.ITEMS)
    private ItemsModel[] items;
    @SerializedName(CallConstants.LANGUAGE_VERSION_NUMBER)
    private int languageVersionNumber;
    @SerializedName(CallConstants.MODIFIED)
    private String modified;
    @SerializedName(CallConstants.SUMMARY)
    private String summary;
    @SerializedName(CallConstants.ENDS_ON)
    private String endOn;
    @SerializedName(CallConstants.VERSION_URL)
    private String versionUrl;
    @SerializedName(CallConstants.SET_TYPE_SLUG)
    private String setTypedSlug;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCashedFilmCount() {
        return cashedFilmCount;
    }

    public void setCashedFilmCount(int cashedFilmCount) {
        this.cashedFilmCount = cashedFilmCount;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getEndOn() {
        return endOn;
    }

    public void setEndOn(String endOn) {
        this.endOn = endOn;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getFilmCount() {
        return filmCount;
    }

    public void setFilmCount(int filmCount) {
        this.filmCount = filmCount;
    }

    public String getFormattedBody() {
        return formattedBody;
    }

    public void setFormattedBody(String formattedBody) {
        this.formattedBody = formattedBody;
    }

    public boolean isHasPrice() {
        return hasPrice;
    }

    public void setHasPrice(boolean hasPrice) {
        this.hasPrice = hasPrice;
    }

    public String getHierarchyUrl() {
        return hierarchyUrl;
    }

    public void setHierarchyUrl(String hierarchyUrl) {
        this.hierarchyUrl = hierarchyUrl;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    public ItemsModel[] getItems() {
        return items;
    }

    public void setItems(ItemsModel[] items) {
        this.items = items;
    }

    public String getLanguageEndsOn() {
        return languageEndsOn;
    }

    public void setLanguageEndsOn(String languageEndsOn) {
        this.languageEndsOn = languageEndsOn;
    }

    public String getLanguageModified() {
        return languageModified;
    }

    public void setLanguageModified(String languageModified) {
        this.languageModified = languageModified;
    }

    public String getLanguageModifiedBy() {
        return languageModifiedBy;
    }

    public void setLanguageModifiedBy(String languageModifiedBy) {
        this.languageModifiedBy = languageModifiedBy;
    }

    public String getLanguagePublishOn() {
        return languagePublishOn;
    }

    public void setLanguagePublishOn(String languagePublishOn) {
        this.languagePublishOn = languagePublishOn;
    }

    public int getLanguageVersionNumber() {
        return languageVersionNumber;
    }

    public void setLanguageVersionNumber(int languageVersionNumber) {
        this.languageVersionNumber = languageVersionNumber;
    }

    public String getLanguageVersionUrl() {
        return languageVersionUrl;
    }

    public void setLanguageVersionUrl(String languageVersionUrl) {
        this.languageVersionUrl = languageVersionUrl;
    }

    public String getLowestAmount() {
        return lowestAmount;
    }

    public void setLowestAmount(String lowestAmount) {
        this.lowestAmount = lowestAmount;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String[] getPlans() {
        return plans;
    }

    public void setPlans(String[] plans) {
        this.plans = plans;
    }

    public String getPublishOn() {
        return publishOn;
    }

    public void setPublishOn(String publishOn) {
        this.publishOn = publishOn;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuoter() {
        return quoter;
    }

    public void setQuoter(String quoter) {
        this.quoter = quoter;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getSetTypedSlug() {
        return setTypedSlug;
    }

    public void setSetTypedSlug(String setTypedSlug) {
        this.setTypedSlug = setTypedSlug;
    }

    public String getSetTypeUrl() {
        return setTypeUrl;
    }

    public void setSetTypeUrl(String setTypeUrl) {
        this.setTypeUrl = setTypeUrl;
    }

    public String getSheduleUrl() {
        return sheduleUrl;
    }

    public void setSheduleUrl(String sheduleUrl) {
        this.sheduleUrl = sheduleUrl;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }

    public String getTempImage() {
        return tempImage;
    }

    public void setTempImage(String tempImage) {
        this.tempImage = tempImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getVersionUrl() {
        return versionUrl;
    }

    public void setVersionUrl(String versionUrl) {
        this.versionUrl = versionUrl;
    }

    public String[] getSheduleUrls() {
        return sheduleUrls;
    }

    public void setSheduleUrls(String[] sheduleUrls) {
        this.sheduleUrls = sheduleUrls;
    }
}
