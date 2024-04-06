package com.elabda3.eldaya7een.UrlPagePackage;

/**
 * Created by ebda3-mint on 10/7/17.
 */

public class UrlPageActivityPresenterImp implements UrlPageActivityPresenter {

    UrlPageActivityView pageActivityView;

    public UrlPageActivityPresenterImp(UrlPageActivityView pageActivityView) {
        this.pageActivityView = pageActivityView;
    }

    @Override
    public void setUrl(String url) {
        pageActivityView.showProgress();
        pageActivityView.initWebView(url);
    }

}
