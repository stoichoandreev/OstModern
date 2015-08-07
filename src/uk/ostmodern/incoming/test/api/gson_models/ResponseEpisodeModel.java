package uk.ostmodern.incoming.test.api.gson_models;

import com.google.gson.annotations.SerializedName;
import uk.ostmodern.incoming.test.api.ResponseBaseModel;
import uk.ostmodern.incoming.test.api.interfaces.ApiModelsInterface;
import uk.ostmodern.incoming.test.constants.CallConstants;

/**
 * Created by sniper on 2015.
 */
public class ResponseEpisodeModel extends ResponseBaseModel implements ApiModelsInterface {
    @SerializedName(CallConstants.SUBTITLE)
    private String subtitle;
    @SerializedName(CallConstants.UID)
    private String uId;
    @SerializedName(CallConstants.SHEDULE_URLS)
    private String[] sheduleUrls;
    @SerializedName(CallConstants.IMAGE_URLS)
    private String[] imageUrls;
    @SerializedName(CallConstants.PUBLISH_ON)
    private String publishOn;
    @SerializedName(CallConstants.TALENT_URLS)
    private String[] talentUrls;
    @SerializedName(CallConstants.SHEDULE_URL)
    private String sheduleUrl;
    @SerializedName(CallConstants.PLAN_URLS)
    private String[] planUrls;
    @SerializedName(CallConstants.LANGUAGE_PUBLISH_ON)
    private String languagePublishOn;
    @SerializedName(CallConstants.EPISODE_NUMBER)
    private String episodeNumber;
    @SerializedName(CallConstants.LANGUAGE_MODIFIED_BY)
    private String languageModifiedBy;
    @SerializedName(CallConstants.SLUG)
    private String slug;
    @SerializedName(CallConstants.LANGUAGE_VERSION_URL)
    private String languageVersionUrl;
    @SerializedName(CallConstants.VERSION_NUMBER)
    private int versionNumber;
    @SerializedName(CallConstants.MODIFIED_BY)
    private String modifiedBy;
    @SerializedName(CallConstants.LANGUAGE_ENDS_ON)
    private String languageEndsOn;
    @SerializedName(CallConstants.TITLE)
    private String title;
    @SerializedName(CallConstants.ITEMS)
    private String[] items;
    @SerializedName(CallConstants.SELF)
    private String self;
    @SerializedName(CallConstants.CREATED)
    private String created;
    @SerializedName(CallConstants.MODIFIED)
    private String modified;
    @SerializedName(CallConstants.CREATED_BY)
    private String createdBy;
    @SerializedName(CallConstants.TAG_URLS)
    private String[] tagsUrls;
    @SerializedName(CallConstants.ENDS_ON)
    private String endsOn;
    @SerializedName(CallConstants.SYNOPSIS)
    private String synopsis;
    @SerializedName(CallConstants.VERSION_URL)
    private String versionUrl;
    @SerializedName(CallConstants.PARENT_URL)
    private String parentUrl;
    @SerializedName(CallConstants.LANGUAGE_VERSION_NUMBER)
    private int languageVersionNumber;
    @SerializedName(CallConstants.LANGUAGE_MODIFIED)
    private String languageModified;

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

    public String getEndsOn() {
        return endsOn;
    }

    public void setEndsOn(String endsOn) {
        this.endsOn = endsOn;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
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

    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

    public String[] getPlanUrls() {
        return planUrls;
    }

    public void setPlanUrls(String[] planUrls) {
        this.planUrls = planUrls;
    }

    public String getPublishOn() {
        return publishOn;
    }

    public void setPublishOn(String publishOn) {
        this.publishOn = publishOn;
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

    public String[] getSheduleUrls() {
        return sheduleUrls;
    }

    public void setSheduleUrls(String[] sheduleUrls) {
        this.sheduleUrls = sheduleUrls;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String[] getTagsUrls() {
        return tagsUrls;
    }

    public void setTagsUrls(String[] tagsUrls) {
        this.tagsUrls = tagsUrls;
    }

    public String[] getTalentUrls() {
        return talentUrls;
    }

    public void setTalentUrls(String[] talentUrls) {
        this.talentUrls = talentUrls;
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

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }
}
