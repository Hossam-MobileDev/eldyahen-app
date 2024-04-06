package com.elabda3.eldaya7een.NewsPackage;

import com.elabda3.eldaya7een.model.NewsAdsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/2/17.
 */

public interface NewsModel {

    interface NewsModelListner{
        void onSuccess(List<NewsDataModel> list);
        void onFailureLoad(String url, int page);
        void onFailure(String alert);
        void onNewsAddsLoaded(List<NewsAdsDataModel> list);
    }

    void getNews(String url, int page, NewsModelListner listner);
    void failureLoadNews(String url, int page, NewsModelListner listner);
    void getNewsAdds(String url, NewsModelListner listner);

}
