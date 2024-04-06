package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/9/17.
 */

public class ImageAlbumDetailsDataModel {


    /**
     * photoid : 640
     * title : فواز بن منقذ بن اسماعيل
     * description : فواز بن منقذ بن اسماعيل
     * photo : http://192.168.0.109/wasama/uploads/thumb/upload_2017_09_29_21_52_3530.jpg
     * share : فواز بن منقذ بن اسماعيل
     تم النشر عن طريق تطبيق تطبيق الوساما
     * datecreate : 2017-09-29 21:52
     * comments : 0
     * api_url : http://192.168.0.109/wasama/api.php?mod=photos&photoid=640
     */

    private String photoid;
    private String title;
    private String description;
    private String photo;
    private String share;
    private String datecreate;
    private int comments;
    private String api_url;

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(String datecreate) {
        this.datecreate = datecreate;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getApi_url() {
        return api_url;
    }

    public void setApi_url(String api_url) {
        this.api_url = api_url;
    }
}
