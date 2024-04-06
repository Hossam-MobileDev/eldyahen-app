package com.elabda3.eldaya7een.NewsDetailsPackage;


import com.elabda3.eldaya7een.model.NewsDetailsDataModel;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public interface NewsDetailsView {

    void showProgress();
    void hideProgress();
    void showAlert(String alert);
    void initViewsWithData(NewsDetailsDataModel details);
    void openCommentsActivity(String newsId);
    void initShare(String msg, String link);
    void setFavourit(NewsDetailsDataModel newsDetailsDataModel);
    void removeFavourit();
}
