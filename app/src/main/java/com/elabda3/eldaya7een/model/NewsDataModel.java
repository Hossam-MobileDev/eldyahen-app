package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public class NewsDataModel {

    /**
     * catId : 92
     * catName : أفراح الكويت
     * newsid : 36
     * title : عبدالحكيم بن عبدالرحمن نقيباً
     * photo : http://192.168.0.109/wasama/uploads/photo/upload_2017_08_30_09_11_2383.jpg
     * lastUpdate :  منذ 1 شهر
     * ar_date : {"nameday":"الأربعاء","day":"30","namemonth":"اغسطس","year":"2017"}
     * date : 30-08-2017
     * time : 09:11 AM
     * description : صدرت الموافقة السامية الكريمة بترقية عبدالحكيم بن عبدالرحمن بن محمد نقيباً ...
     * share : عبدالحكيم بن عبدالرحمن نقيباً
     صدرت الموافقة السامية الكريمة بترقية عبدالحكيم بن عبدالرحمن بن محمد نقيباً بوزارة الداخلية.نبارك لأبن ...
     تم النشر عن طريق تطبيق أسرة العمار
     * views : 92
     * numberOfComments : 0
     * numberOfLikes : 0
     * numberOfDislikes : 0
     * userId : 2
     * userName : null
     * userPhoto : http://192.168.0.109/wasama/uploads/users/no_avatar.png
     * url : http://192.168.0.109/wasama/api.php?mod=news&nid=36
     * next : none
     * prev : http://192.168.0.109/wasama/api.php?mod=news&nid=22
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
    private int numberOfComments;
    private int numberOfLikes;
    private int numberOfDislikes;
    private String userId;
    private Object userName;
    private String userPhoto;
    private String url;
    private String next;
    private String prev;

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
         * nameday : الأربعاء
         * day : 30
         * namemonth : اغسطس
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
