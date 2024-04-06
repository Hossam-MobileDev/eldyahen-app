package com.elabda3.eldaya7een.SendSMSPackage;

/**
 * Created by ebda3-mint on 10/28/17.
 */

public interface SendSmsView {

    void showProgress();
    void hideProgress();

    void smsSent(String msg);
    void showAlert(String msg);

}
