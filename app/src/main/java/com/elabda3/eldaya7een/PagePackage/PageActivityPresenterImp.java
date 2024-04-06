package com.elabda3.eldaya7een.PagePackage;


import com.elabda3.eldaya7een.model.PageDataModel;

/**
 * Created by ebda3-mint on 10/7/17.
 */

public class PageActivityPresenterImp implements PageActivityPresenter, PageActivityModel.Listner {

    PageActivityModelImp pageActivityModelImp;
    PageActivityView pageActivityView;

    public PageActivityPresenterImp(PageActivityView pageActivityView) {
        this.pageActivityView = pageActivityView;
        pageActivityModelImp=new PageActivityModelImp();
    }

    @Override
    public void setUrl(String url) {
        pageActivityModelImp.getPageContentFromServer(url,this);
    }

    @Override
    public void onSuccess(PageDataModel pageDataModel) {
        pageActivityView.dismissProgress();
        pageActivityView.initWebViewWithData(pageDataModel);
    }

    @Override
    public void onFailure(String msg) {
        pageActivityView.dismissProgress();
        pageActivityView.showAlert(msg);
    }
}
