package uk.ostmodern.incoming.test.api.gson_models;

import com.google.gson.annotations.SerializedName;
import uk.ostmodern.incoming.test.api.ResponseBaseModel;
import uk.ostmodern.incoming.test.api.interfaces.ApiModelsInterface;
import uk.ostmodern.incoming.test.constants.CallConstants;

/**
 * Created by sniper on 2015.
 */
public class ResponseImageModel extends ResponseBaseModel implements ApiModelsInterface {
    @SerializedName(CallConstants.UID)
    private String uId;
    @SerializedName(CallConstants.SHOW)
    private boolean show;
    @SerializedName(CallConstants.SHEDULE_URL)
    private String sheduleUrl;
    @SerializedName(CallConstants.CONTENT_URL)
    private String contentUrl;
    @SerializedName(CallConstants.URL)
    private String url;
    @SerializedName(CallConstants.IMAGE_TYPE_URL)
    private String imageTypeUrl;
    @SerializedName(CallConstants.UPLOAD_IMAGE_URL)
    private String uploadImageUrl;
    @SerializedName(CallConstants.LANGUAGE_MODIFIED_BY)
    private String languageModifiedBy;
    @SerializedName(CallConstants.LANGUAGE_VERSION_URL)
    private String languageVersionUrl;
    @SerializedName(CallConstants.DESCRIPTION)
    private String description;
    @SerializedName(CallConstants.LANGUAGE_ENDS_ON)
    private String languageEndsOn;
    @SerializedName(CallConstants.IMAGE_TYPE)
    private String imageType;
    @SerializedName(CallConstants.TITLE)
    private String title;
    @SerializedName(CallConstants.SELF)
    private String self;
    @SerializedName(CallConstants.CREATED)
    private String created;
    @SerializedName(CallConstants.CREATED_BY)
    private String createdBy;
    @SerializedName(CallConstants.LANGUAGE_VERSION_NUMBER)
    private int languageVersionNumber;
    @SerializedName(CallConstants.LANGUAGE_PUBLISH_ON)
    private String languagePublishOn;
    @SerializedName(CallConstants.LANGUAGE_MODIFIED)
    private String languageModified;
    @SerializedName(CallConstants.POSITION)
    private String position;
    @SerializedName(CallConstants.ALIGN)
    private String align;

    private String imageKey;

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageTypeUrl() {
        return imageTypeUrl;
    }

    public void setImageTypeUrl(String imageTypeUrl) {
        this.imageTypeUrl = imageTypeUrl;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getSheduleUrl() {
        return sheduleUrl;
    }

    public void setSheduleUrl(String sheduleUrl) {
        this.sheduleUrl = sheduleUrl;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
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

    public String getUploadImageUrl() {
        return uploadImageUrl;
    }

    public void setUploadImageUrl(String uploadImageUrl) {
        this.uploadImageUrl = uploadImageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }
}
