package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public class NewsDetailsDataModel {


    /**
     * catName : أفراح الكويت
     * catId : 92
     * newsid : 22
     * title : أمين منطقة القصيم يبارك للدكتور عبدالمحسن
     * photo : http://192.168.0.109/wasama/uploads/photo/upload_2017_10_02_18_07_4524.jpg
     * lastUpdate :  منذ 14 يوم
     * ar_date : {"nameday":"الاثنين","day":"18","namemonth":"سبتمبر","year":"2017"}
     * date : 18-09-2017
     * time : 09:29 PM
     * description : أمين القصيم م.محمد المجلي يستقبل رئيس بلدية النبهانية د.عبدالمحسن العمار ويبارك ...
     * share : أمين منطقة القصيم يبارك للدكتور عبدالمحسن
     أمين القصيم م.محمد المجلي يستقبل رئيس بلدية النبهانية د.عبدالمحسن العمار ويبارك لمنسوبي البلدية بمناسبة ...
     تم النشر عن طريق تطبيق أسرة العمار
     * views : 37
     * numberOfComments : 0
     * numberOfLikes : 0
     * numberOfDislikes : 0
     * content : <div style='text-align:right;color:#ff0011;direction:rtl;'>: </div><div style="direction:rtl;text-align:center;font-size:15px !important;font-weight:bold;"><p>أمين القصيم م.محمد المجلي يستقبل رئيس بلدية النبهانية د.عبدالمحسن العمار ويبارك لمنسوبي البلدية بمناسبة الحصول على شهادة الأيزو العالمية.<br />
     <br />
     وبهذا الصدد تبارك أسرة العمار للدكتور عبدالمحسن تحقيق هذا الإنجاز وتتمنى له دوام التوفيق والسداد.</p><br><img src="http://192.168.0.109/wasama/uploads/photo/upload_2014_12_20_15_11_5581.jpg" alt="" style="width:300px;height:225px;"><br><img src="http://192.168.0.109/wasama/uploads/photo/upload_2017_09_18_21_29_5736.jpeg" alt="" style="width:300px;height:225px;"></div>
     * photosList : ["http://192.168.0.109/wasama/uploads/photo/upload_2014_12_20_15_11_5581.jpg","http://192.168.0.109/wasama/uploads/photo/upload_2017_09_18_21_29_5736.jpeg"]
     * userId : 2
     * userName : null
     * userPhoto : http://192.168.0.109/wasama/uploads/users/no_avatar.png
     * url : http://192.168.0.109/wasama/api.php?mod=news&nid=22
     * siteurl : http://alammar.info/news.php?nid=22
     * next : http://192.168.0.109/wasama/api.php?mod=news&nid=36
     * prev : http://192.168.0.109/wasama/api.php?mod=news&nid=21
     */

    private String catName;
    private String catId;
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
    private int numberOfComments;
    private int numberOfLikes;
    private int numberOfDislikes;
    private String content;
    private String userId;
    private Object userName;
    private String userPhoto;
    private String url;
    private String siteurl;
    private String next;
    private String prev;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
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

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public int getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public void setNumberOfDislikes(int numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getSiteurl() {
        return siteurl;
    }

    public void setSiteurl(String siteurl) {
        this.siteurl = siteurl;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public static class ArDateBean {
        /**
         * nameday : الاثنين
         * day : 18
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
