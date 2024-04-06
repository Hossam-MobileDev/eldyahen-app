package com.elabda3.eldaya7een.HomeFragmentPackage;

import com.elabda3.eldaya7een.model.AdsDataModel;
import com.elabda3.eldaya7een.model.HomeCatsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/2/17.
 */

public interface HomeFragmentView {

    void initCatRecycler(List<HomeCatsDataModel> list);
    void showProgress();
    void hideProgress();
    void showAlert(String alert);
    void initViewPager(List<AdsDataModel> list);

    void initAdsHorizontal(List<NewsDataModel> list);
    void adsHorizontalFail();




}
