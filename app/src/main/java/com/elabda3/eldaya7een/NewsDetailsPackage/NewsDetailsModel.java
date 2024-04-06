package com.elabda3.eldaya7een.NewsDetailsPackage;


import com.elabda3.eldaya7een.model.NewsDetailsDataModel;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public interface NewsDetailsModel {

    interface NewsDetailsListner{

        void Success(NewsDetailsDataModel newsDetailsDataModel);
        void failure(String alert);
    }

    void getNewsFromServer(String url, NewsDetailsListner lisner);

    String getNewsId();
}
