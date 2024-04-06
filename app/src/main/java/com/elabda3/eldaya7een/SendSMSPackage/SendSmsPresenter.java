package com.elabda3.eldaya7een.SendSMSPackage;

/**
 * Created by ebda3-mint on 10/28/17.
 */

public interface SendSmsPresenter {

    void sendSmsDataToServer(String senderPhone, String deliverdPhone, String msg, String date);

}
