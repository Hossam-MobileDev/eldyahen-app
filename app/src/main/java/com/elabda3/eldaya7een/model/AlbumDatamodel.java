package com.elabda3.eldaya7een.model;

import java.util.List;

/**
 * Created by ebda3-mint on 10/8/17.
 */

public class AlbumDatamodel {

    /**
     * albumid : 1
     * title : عرّف نفسك بصورة
     * description : هنا ديوانية للتعارف بالصورة مع التعريف الشخصي.
     * photolist : ["http://192.168.0.109/wasama/uploads/thumb/no_photo.png","http://192.168.0.109/wasama/uploads/thumb/no_photo.png"]
     * photo : http://192.168.0.109/wasama/uploads/thumb/upload_2014_11_24_12_26_57.jpg
     * totalitems : 17
     * api_url : http://192.168.0.109/wasama/api.php?mod=photos&albumid=1
     */

    private String albumid;
    private String title;
    private String description;
    private String photo;
    private int totalitems;
    private String api_url;
    private List<String> photolist;

    public String getAlbumid() {
        return albumid;
    }

    public void setAlbumid(String albumid) {
        this.albumid = albumid;
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

    public int getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(int totalitems) {
        this.totalitems = totalitems;
    }

    public String getApi_url() {
        return api_url;
    }

    public void setApi_url(String api_url) {
        this.api_url = api_url;
    }

    public List<String> getPhotolist() {
        return photolist;
    }

    public void setPhotolist(List<String> photolist) {
        this.photolist = photolist;
    }
}
