package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/9/17.
 */

public class VideoDataModel {

    /**
     * videoid : 8
     * title : اجمل موسيقى تركية رائعة مجموعة مقاطع (حسنو - كلارنيت)    https://www.youtube.com/watch?v=jxd1q_ok6DI
     * description : اجمل موسيقى تركية رائعة مجموعة مقاطع (حسنو - كلارنيت)اجمل موسيقى تركية رائعة مجموعة مقاطع (حسنو - كلارنيت)اجمل موسيقى تركية رائعة مجموعة مقاطع (حسنو - كلارنيت)اجمل موسيقى تركية رائعة مجموعة مقاطع (حسنو - كلارنيت)
     * provider : youtube
     * photo : https://i.ytimg.com/vi/jxd1q_ok6DI/0.jpg
     * videourl : https://www.youtube.com/watch?v=jxd1q_ok6DI
     * share : اجمل موسيقى تركية رائعة مجموعة مقاطع (حسنو - كلارنيت)
     https://www.youtube.com/watch?v=jxd1q_ok6DI
     تم النشر عن طريق تطبيق تطبيق الوساما
     * datecreate : 2017-10-09 14:33:00
     * comments : 0
     * views : 0
     * link : http://192.168.0.109/wasama/api.php?mod=videos&videoid=8
     */

    private String videoid;
    private String title;
    private String description;
    private String provider;
    private String photo;
    private String videourl;
    private String share;
    private String datecreate;
    private int comments;
    private String views;
    private String link;

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
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

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
