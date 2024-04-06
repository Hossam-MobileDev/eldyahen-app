package com.elabda3.eldaya7een.ContactUsPackage;

/**
 * Created by ebda3-mint on 10/10/17.
 */

public interface ContactUsView {

    void showProgress();
    void dismissProgress();
    void showAlert(String alert);
    void clearViews();

    void openFaceUrl(String url);
    void openYoutubeUrl(String url);
    void openInstaUrl(String url);
    void openTwitterUrl(String url);

    void setPhoneNumber(String phone1, String phone2);


}
