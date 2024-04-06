package com.elabda3.eldaya7een.model;

/**
 * Created by ebda3-mint on 10/28/17.
 */

public class SendSmsDataModel {

    /**
     * status : done
     * message : تم الارسال بنجاح .. بإنتظار مراجعة الادارة
     * itemid : 0
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
