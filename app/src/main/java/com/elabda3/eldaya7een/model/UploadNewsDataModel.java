package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/3/17.
 */

public class UploadNewsDataModel {


    /**
     * status : done
     * message : تم اضافة الخبر بنجاح.
     * itemid : 39
     */

    private String status;
    private String message;
    private int itemid;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
}
