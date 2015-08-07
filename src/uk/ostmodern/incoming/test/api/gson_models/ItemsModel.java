package uk.ostmodern.incoming.test.api.gson_models;

import com.google.gson.annotations.SerializedName;
import uk.ostmodern.incoming.test.constants.CallConstants;

import java.io.Serializable;

/**
 * Created by sniper on 2015.
 */
public class ItemsModel implements Serializable{
    @SerializedName(CallConstants.LINK_URL)
    private String linkUrl;
    @SerializedName(CallConstants.SUB_HEADING)
    private String subHeading;
    @SerializedName(CallConstants.UID)
    private String uId ;
    @SerializedName(CallConstants.LINK_TITLE)
    private String linkTitle ;
    @SerializedName(CallConstants.SELF)
    private String self;
    @SerializedName(CallConstants.CONTENT_URL)
    private String contentUrl;
    @SerializedName(CallConstants.SHEDULE_URL)
    private String sheduleUrl;
    @SerializedName(CallConstants.SET_URL)
    private String setUrl ;
    @SerializedName(CallConstants.CONTENT_TYPE)
    private String contentType;
    @SerializedName(CallConstants.POSITION)
    private int position;
    @SerializedName(CallConstants.HEADING)
    private String heading;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getSetUrl() {
        return setUrl;
    }

    public void setSetUrl(String setUrl) {
        this.setUrl = setUrl;
    }

    public String getSheduleUrl() {
        return sheduleUrl;
    }

    public void setSheduleUrl(String sheduleUrl) {
        this.sheduleUrl = sheduleUrl;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
