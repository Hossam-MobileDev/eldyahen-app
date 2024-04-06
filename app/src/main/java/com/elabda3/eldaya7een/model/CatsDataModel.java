package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/3/17.
 */

public class CatsDataModel {

    /**
     * catId : 92
     * title : أفراح الكويت
     * photo : http://192.168.0.109/wasama/uploads/thumb/upload_2017_10_01_15_45_5983.png
     * totalitems : 6
     * url : http://192.168.0.109/wasama/api.php?mod=news&cid=92
     * subcategoriestotal : 0
     * subcategories :
     */

    private String catId;
    private String title;
    private String photo;
    private String url;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
