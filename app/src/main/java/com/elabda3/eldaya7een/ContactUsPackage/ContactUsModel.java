package com.elabda3.eldaya7een.ContactUsPackage;


import com.elabda3.eldaya7een.model.SocialDataModel;

/**
 * Created by ebda3-mint on 10/10/17.
 */

public interface ContactUsModel {

    interface Listner{
        void onSuccess(String msg, boolean statusDone);
        void onSocialSuccess(SocialDataModel socialDataModel);
        void onSocialFailure(String msg);
        void onFailure(String msg);
    }

    void sendContactToServer(String name, String email, String msg, Listner lister);
    void getSocail(String url, Listner lister);
}
