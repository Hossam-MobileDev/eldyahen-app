package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/4/17.
 */

public class NewsAdsDataModel {

    /**
     * adsid : 48
     * title : مساحه اعلانيه 1
     * type : image
     * fileurl : http://eyn3.com/sites/default/files/4661.jpg
     * targeturl : https://twitter.com/bnitamem_app
     * htmlcode :
     * lastupdate : 2015-02-08
     * url : http://192.168.0.109/wasama/api.php?mod=ads&adsid=48
     */

    private String adsid;
    private String title;
    private String type;
    private String fileurl;
    private String targeturl;
    private String htmlcode;
    private String lastupdate;
    private String url;

    public String getAdsid() {
        return adsid;
    }

    public void setAdsid(String adsid) {
        this.adsid = adsid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public String getTargeturl() {
        return targeturl;
    }

    public void setTargeturl(String targeturl) {
        this.targeturl = targeturl;
    }

    public String getHtmlcode() {
        return htmlcode;
    }

    public void setHtmlcode(String htmlcode) {
        this.htmlcode = htmlcode;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
