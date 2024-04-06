package com.elabda3.eldaya7een.SendSMSPackage;


import com.elabda3.eldaya7een.model.SendSmsDataModel;

/**
 * Created by ebda3-mint on 10/28/17.
 */

public class SendSmsPresenterImp implements SendSmsPresenter, SendSmsModel.Listner {

    SendSmsView sendSmsView;
    SendSmsModelImp sendSmsModelImp;

    public SendSmsPresenterImp(SendSmsView sendSmsView) {
        this.sendSmsView = sendSmsView;
        sendSmsModelImp=new SendSmsModelImp();
    }

    @Override
    public void sendSmsDataToServer(String senderPhone, String deliverdPhone, String msg, String date) {
        sendSmsView.showProgress();
        sendSmsModelImp.sendSmsToServer(senderPhone,deliverdPhone,msg,date,this);
    }

    @Override
    public void onSuccess(SendSmsDataModel sendSmsDataModel) {
        sendSmsView.hideProgress();
        sendSmsView.smsSent(sendSmsDataModel.getMessage());
    }

    @Override
    public void onFailure(String msg) {
        sendSmsView.hideProgress();
        sendSmsView.showAlert(msg);
    }
}
