package com.elabda3.eldaya7een.aboutUsPackage;


import com.elabda3.eldaya7een.model.WebDataModel;

/**
 * Created by ebda3-mint on 10/4/17.
 */

public class AboutUsPresenterImp implements AboutUsPresenter, AboutUsModel.Listner {

    AboutUsView aboutUsView;
    AboutUsModel aboutUsModel;

    public AboutUsPresenterImp(AboutUsView aboutUsView) {
        this.aboutUsView = aboutUsView;
        aboutUsModel=new AboutUsModelImp();
        aboutUsModel.getWebContentFromServer("http://aldaihani.org/aldaih/api.php?mod=pages&pageid=5",this);
    }

    @Override
    public void onSuccess(WebDataModel dataModel) {
        aboutUsView.dismissProgress();
        aboutUsView.loadDataToWebView(dataModel);
    }

    @Override
    public void onFailure(String alert) {
        aboutUsView.dismissProgress();
        aboutUsView.showAlert(alert);
    }
}
