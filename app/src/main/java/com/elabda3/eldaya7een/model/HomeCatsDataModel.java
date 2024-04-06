package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public class HomeCatsDataModel {


    /**
     * id : 77
     * catid : 92
     * title : أفراح الكويت
     * url : http://localhost/wasama/api.php?mod=news&cid=92
     * type : category-news
     * photo : http://localhost/wasama/uploads/thumb/upload_2017_10_01_15_45_5983.png
     * lastupdate : none
     * subcategoriesCount : none
     * subcategories : none
     * visitor : allow
     * totalitems : 6
     */

    private String id;
    private String catid;
    private String title;
    private String url;
    private String type;
    private String photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
