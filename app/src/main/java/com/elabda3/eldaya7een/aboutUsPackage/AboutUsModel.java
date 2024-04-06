package com.elabda3.eldaya7een.aboutUsPackage;


import com.elabda3.eldaya7een.model.WebDataModel;

/**
 * Created by ebda3-mint on 10/4/17.
 */

public interface AboutUsModel {

    interface Listner{

        void onSuccess(WebDataModel dataModel);
        void onFailure(String alert);
    }

    void getWebContentFromServer(String url, Listner listner);
}
