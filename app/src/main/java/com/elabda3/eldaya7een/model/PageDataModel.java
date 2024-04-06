package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/7/17.
 */

public class PageDataModel {

    /**
     * title : رسائل sms الوساما
     * content : <p>رسائل sms الوساما<br></p>
     * content_clear : رسائل sms الوساما
     * share : رسائل sms الوساما
     * photo : http://192.168.0.109/wasama/uploads/thumb/
     * lastupdate : 2017-10-01 16:06:00
     */

    private String title;
    private String content;
    private String content_clear;
    private String share;
    private String photo;
    private String lastupdate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_clear() {
        return content_clear;
    }

    public void setContent_clear(String content_clear) {
        this.content_clear = content_clear;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }
}
