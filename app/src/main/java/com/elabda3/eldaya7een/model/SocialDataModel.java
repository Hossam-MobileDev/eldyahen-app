package com.elabda3.eldaya7een.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ebda3-mint on 10/8/17.
 */

public class SocialDataModel {

    /**
     * title :
     * address : 2 شارع جسر السويس / عمارات الميرلاند 2212212
     * lat : 6856564546
     * long : 513211549
     * site : 888
     * youtube : youtube
     * twitter : alammar_family
     * instagram : alammar_family
     * facebook : https://www.facebook.com/el.abda3/
     * facebookID : 159016237480766
     * skype : skype
     * googleplus : alammar_family
     */

    private String title;
    private String address;
    private String lat;
    @SerializedName("long")
    private String longX;
    private String site;
    private String youtube;
    private String twitter;
    private String instagram;
    private String facebook;
    private String facebookID;
    private String skype;
    private String googleplus;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongX() {
        return longX;
    }

    public void setLongX(String longX) {
        this.longX = longX;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getGoogleplus() {
        return googleplus;
    }

    public void setGoogleplus(String googleplus) {
        this.googleplus = googleplus;
    }
}
