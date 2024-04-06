package com.elabda3.eldaya7een.UrlPagePackage;

/**
 * Created by ebda3-mint on 10/7/17.
 */

public interface UrlPageActivityView {

    void showProgress();
    void dismissProgress();
    void showAlert(String alert);
    void initWebView(String url);
}
