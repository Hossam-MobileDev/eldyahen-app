package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/3/17.
 */

public class CommentsDataModel {


    /**
     * username : ahmed
     * userid : 0
     * userphoto : http://192.168.0.109/wasama/uploads/users/
     * commentid : 47
     * content : cxvxcvxvxc sdfds
     * likesnumber : 0
     * dislikenumber : 0
     * date : 2017-10-01 16:23
     * stringtime :  منذ 2 يوم
     */

    private String username;
    private String userid;
    private String userphoto;
    private String commentid;
    private String content;
    private int likesnumber;
    private int dislikenumber;
    private String date;
    private String stringtime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikesnumber() {
        return likesnumber;
    }

    public void setLikesnumber(int likesnumber) {
        this.likesnumber = likesnumber;
    }

    public int getDislikenumber() {
        return dislikenumber;
    }

    public void setDislikenumber(int dislikenumber) {
        this.dislikenumber = dislikenumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStringtime() {
        return stringtime;
    }

    public void setStringtime(String stringtime) {
        this.stringtime = stringtime;
    }
}
