package com.elabda3.eldaya7een.NewsPackage;

import com.elabda3.eldaya7een.model.NewsAdsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/2/17.
 */

public interface NewsActivityView {

    void showProgress();
    void hideProgress();
    void initNewsRecycler(List<NewsDataModel> list);
    void initViewPager(List<NewsAdsDataModel> list);
    void showAlert(String alert);
    void nextAds(int pos);



}
