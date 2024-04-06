package com.elabda3.eldaya7een.aboutUsPackage;


import com.elabda3.eldaya7een.model.WebDataModel;

/**
 * Created by ebda3-mint on 10/4/17.
 */

public interface AboutUsView {

    void showProgress();
    void dismissProgress();
    void showAlert(String alert);
    void loadDataToWebView(WebDataModel dataModel);
}
