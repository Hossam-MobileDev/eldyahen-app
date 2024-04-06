package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/8/17.
 */

public class CalenderDataModel {

    /**
     * id : 88
     * title : افراح الحثلين
     * content : سعد سحيمان الحثلين<br />
     ديوان سالم العلي
     * eventdate : 2016-10-11 21:00:00
     * ar_date : {"nameday":"الثلاثاء","day":"11","namemonth":"اكتوبر","year":"2016"}
     * photo : http://192.168.0.109/wasama/uploads/thumb/no_photo.png
     */

    private String id;
    private String title;
    private String content;
    private String eventdate;
    private ArDateBean ar_date;
    private String photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public ArDateBean getAr_date() {
        return ar_date;
    }

    public void setAr_date(ArDateBean ar_date) {
        this.ar_date = ar_date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public static class ArDateBean {
        /**
         * nameday : الثلاثاء
         * day : 11
         * namemonth : اكتوبر
         * year : 2016
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
