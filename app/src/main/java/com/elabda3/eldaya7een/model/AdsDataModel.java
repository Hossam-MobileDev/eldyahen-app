package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public class AdsDataModel {


    /**
     * catId : 117
     * catName : ديوانيات الوساما
     * newsid : 34
     * title : أسرة العمار وفروعها الستة
     * photo : http://192.168.0.109/wasama/uploads/photo/upload_2017_10_02_18_07_4524.jpg
     * lastUpdate : 2017-09-24 19:05:00
     * ar_date : {"nameday":"الأحد","day":"24","namemonth":"سبتمبر","year":"2017"}
     * date : 24-09-2017
     * time : 07:05 PM
     * description : أسرة العمار أبناء عبدالرحمن بن عمار ، من الأسر المتحضرة في نجد ، حيث عاش عمار في ...
     * share : أسرة العمار وفروعها الستة
     أسرة العمار أبناء عبدالرحمن بن عمار ، من الأسر المتحضرة في نجد ، حيث عاش عمار في النصف الثاني من القرن ...
     تم النشر عن طريق تطبيق أسرة العمار
     * views : 172
     * numberOfComments : 0
     * numberOfLikes : 0
     * numberOfDislikes : 0
     * userId : 0
     * userName : null
     * userPhoto : http://192.168.0.109/wasama/uploads/users/no_avatar.png
     * url : http://192.168.0.109/wasama/api.php?mod=news&nid=34
     * next : http://192.168.0.109/wasama/api.php?mod=news&nid=35
     * prev : http://192.168.0.109/wasama/api.php?mod=news&nid=23
     */

    private String catId;
    private String catName;
    private String newsid;
    private String title;
    private String photo;
    private String lastUpdate;
    private ArDateBean ar_date;
    private String date;
    private String time;
    private String description;
    private String share;
    private int views;
    private String userId;
    private Object userName;
    private String userPhoto;
    private String url;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
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

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public ArDateBean getAr_date() {
        return ar_date;
    }

    public void setAr_date(ArDateBean ar_date) {
        this.ar_date = ar_date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getUserName() {
        return userName;
    }

    public void setUserName(Object userName) {
        this.userName = userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class ArDateBean {
        /**
         * nameday : الأحد
         * day : 24
         * namemonth : سبتمبر
         * year : 2017
         */

        private String nameday;
        private String day;
        private String namemonth;
        private String year;

        public String getNameday() {
            return nameday;
        }

        public void setNameday(String nameday) {
            this.nameday = nameday;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getNamemonth() {
            return namemonth;
        }

        public void setNamemonth(String namemonth) {
            this.namemonth = namemonth;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
    }
}
