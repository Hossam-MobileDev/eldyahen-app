package com.elabda3.eldaya7een.ContactUsPackage;

/**
 * Created by ebda3-mint on 10/10/17.
 */

public interface ContactUsPresenter {


    void setContactData(String name, String email, String comment);
    void setSocialUrl(String url);

    void openFaceUrl();
    void openYoutubeUrl();
    void openInstaUrl();
    void openTwitterUrl();


}
