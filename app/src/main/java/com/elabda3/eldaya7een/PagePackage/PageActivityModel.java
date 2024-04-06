package com.elabda3.eldaya7een.PagePackage;


import com.elabda3.eldaya7een.model.PageDataModel;

/**
 * Created by ebda3-mint on 10/7/17.
 */

public interface PageActivityModel {

    interface Listner{

        void onSuccess(PageDataModel pageDataModel);
        void onFailure(String msg);

    }

    void getPageContentFromServer(String url, Listner listner);

}
