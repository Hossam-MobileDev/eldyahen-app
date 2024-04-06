package com.elabda3.eldaya7een.NewsDetailsPackage;


import com.elabda3.eldaya7een.model.NewsDetailsDataModel;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public class NewsDetailsPresenterImp implements NewsDetailsPresenter, NewsDetailsModel.NewsDetailsListner {

    NewsDetailsView newsDetailsView;
    NewsDetailsModel newsDetailsModel;
    NewsDetailsDataModel newsDetailsDataModel;

    public NewsDetailsPresenterImp(NewsDetailsView newsDetailsView) {
        this.newsDetailsView = newsDetailsView;
        newsDetailsModel=new NewsDetailsModelImp();
    }

    @Override
    public void setUrl(String url) {
        newsDetailsView.showProgress();
        newsDetailsModel.getNewsFromServer(url,this);
    }

    @Override
    public void getNewsId() {
        if(newsDetailsDataModel != null) {
            String newsId = newsDetailsModel.getNewsId();
            newsDetailsView.openCommentsActivity(newsId);
        }
    }

    @Override
    public void getShare() {

        if (newsDetailsDataModel != null)
        newsDetailsView.initShare(newsDetailsDataModel.getShare() , newsDetailsDataModel.getSiteurl());
    }

    @Override
    public void getFav() {
        newsDetailsView.setFavourit(newsDetailsDataModel);
    }

    @Override
    public void removeFav() {
        newsDetailsView.removeFavourit();
    }


    @Override
    public void Success(NewsDetailsDataModel newsDetailsDataModel) {
        this.newsDetailsDataModel=newsDetailsDataModel;
        newsDetailsView.initViewsWithData(newsDetailsDataModel);
        newsDetailsView.hideProgress();
    }

    @Override
    public void failure(String alert) {

        newsDetailsView.showAlert(alert);
        newsDetailsView.hideProgress();

    }


}
