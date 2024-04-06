package com.elabda3.eldaya7een.SendSMSPackage;


import com.elabda3.eldaya7een.model.SendSmsDataModel;

/**
 * Created by ebda3-mint on 10/28/17.
 */

public interface SendSmsModel {

    interface Listner{

        void onSuccess(SendSmsDataModel sendSmsDataModel);
        void onFailure(String msg);

    }

    void sendSmsToServer(String senderPhone, String deliverdPhone, String msg, String date, Listner listner);

}
