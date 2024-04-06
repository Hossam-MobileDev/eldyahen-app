package com.elabda3.eldaya7een.AdsPackage;

import android.util.Log;

import com.elabda3.eldaya7een.model.NewsAdsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/2/17.
 */

public class AdsPresenterImp implements AdsPresenter, AdsModel.AdsListner {

    AdsView adsView;
    AdsModel adsModel;


    public AdsPresenterImp(AdsView adsView) {

        this.adsView=adsView;
        adsModel=new AdsModelImp();
        adsModel.getAdsFromServer("http://aldaihani.org/aldaih/api.php?mod=ads&gid=2",this);

    }




    @Override
    public void adsLoaded(List<NewsAdsDataModel> list) {

        Log.v("adsPresenter","loades");
        adsView.dismissProgress();
        adsView.initViewPager(list);

    }

    @Override
    public void fail() {
        Log.v("adsPresenter","notloaded");

    }


}
