package com.elabda3.eldaya7een.NewsPackage;

import com.elabda3.eldaya7een.model.NewsAdsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/2/17.
 */

public class NewsPresenterImp implements NewsPresenter, NewsModel.NewsModelListner {

    NewsActivityView newsView;
    NewsModel newsModel;

    public NewsPresenterImp(NewsActivityView newsView) {
        this.newsView=newsView;
        newsModel=new NewsModelImp();
        newsModel.getNewsAdds("http://aldaihani.org/aldaih/api.php?mod=ads&gid=1",this);
    }

    @Override
    public void setNewsUrl(String url ,int page) {
        newsModel.getNews(url,page ,this);

    }

    @Override
    public void onSuccess(List<NewsDataModel> list) {
        newsView.hideProgress();
        newsView.initNewsRecycler(list);

    }

    @Override
    public void onFailureLoad(String url, int page) {
        newsView.hideProgress();
        newsModel.failureLoadNews(url,page,this);
    }

    @Override
    public void onFailure(String alert) {
        newsView.hideProgress();
        newsView.showAlert(alert);
    }

    @Override
    public void onNewsAddsLoaded(List<NewsAdsDataModel> list) {
        newsView.initViewPager(list);

    }

}
