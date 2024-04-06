package com.elabda3.eldaya7een.PagePackage;


import com.elabda3.eldaya7een.model.PageDataModel;

/**
 * Created by ebda3-mint on 10/7/17.
 */

public interface PageActivityView  {

    void showProgress();
    void dismissProgress();
    void showAlert(String alert);
    void initWebViewWithData(PageDataModel pageDataModel);
}
