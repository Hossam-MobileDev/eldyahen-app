package com.elabda3.eldaya7een.AdsPackage;

import com.elabda3.eldaya7een.model.NewsAdsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/2/17.
 */

public interface AdsModel {

    interface AdsListner{
        void adsLoaded(List<NewsAdsDataModel> list);
        void fail();
    }

    void getAdsFromServer(String url, AdsListner listner);

}
