package com.elabda3.eldaya7een.HomeFragmentPackage;

import android.util.Log;

import com.elabda3.eldaya7een.model.AdsDataModel;
import com.elabda3.eldaya7een.model.HomeCatsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;
import com.elabda3.eldaya7een.model.SendTokenDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/2/17.
 */

public class HomeFragmentPresenterImp implements HomeFragmentPresenter,
        HomeFragmentModel.HomeFragmentModelListner {

    HomeFragmentView homeFragmentView;
    HomeFragmentModel homeFragmentModel;


    public HomeFragmentPresenterImp(HomeFragmentView homeFragmentView) {
        this.homeFragmentView = homeFragmentView;
        homeFragmentModel=new HomeFragmentModelImp();
        homeFragmentModel.getCatsFromServer(this);
        homeFragmentModel.getNewsAdds(this);

    }

    @Override
    public void onSuccess(List<HomeCatsDataModel> list) {
        homeFragmentView.initCatRecycler(list);
        homeFragmentView.hideProgress();
    }

    @Override
    public void onFailure(String alert) {
        homeFragmentView.hideProgress();
        homeFragmentView.showAlert(alert);
    }

    @Override
    public void onNewsAddsLoaded(List<AdsDataModel> list) {
        homeFragmentView.initViewPager(list);
    }



    @Override
    public void onNewsAdsHorizontalLoaded(List<NewsDataModel> list) {
    homeFragmentView.initAdsHorizontal(list);
    }

    @Override
    public void onNewsAdsHorizontalFail() {
        homeFragmentView.adsHorizontalFail();
    }



    @Override
    public void getNewsHorizontal() {
        homeFragmentModel.getNewsAddsHorizontal(this);
    }
}
