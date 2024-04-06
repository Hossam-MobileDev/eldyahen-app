package com.elabda3.eldaya7een.NewsPackage;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.DefaultDataModel;
import com.elabda3.eldaya7een.model.NewsAdsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public class NewsModelImp implements NewsModel {

    @Override
    public void getNews(final String url, final int page , final NewsModelListner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<NewsDataModel>> conn=retrofitApi.getNews(url ,page);
        conn.enqueue(new Callback<List<NewsDataModel>>() {
            @Override
            public void onResponse(Call<List<NewsDataModel>> call, Response<List<NewsDataModel>> response) {

                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<NewsDataModel>> call, Throwable t) {

                listner.onFailureLoad(url,page);
              //  listner.onFailure("حدث خطأ");

            }
        });


    }

    @Override
    public void failureLoadNews(String url, int page, final NewsModelListner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<DefaultDataModel> conn=retrofitApi.getNoNews(url ,page);
        conn.enqueue(new Callback<DefaultDataModel>() {
            @Override
            public void onResponse(Call<DefaultDataModel> call, Response<DefaultDataModel> response) {

                if(response.body().getStatus().equals("error")){
                   // listner.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<DefaultDataModel> call, Throwable t) {

               // listner.onFailure("حدث خطأ");

            }
        });

    }

    @Override
    public void getNewsAdds(String url, final NewsModelListner listner) {

        RetrofitApi retrofitApi=SingletonRetrofit.getRetrofitInstant();
        Call<List<NewsAdsDataModel>> conn=retrofitApi.getNewsAds(url);
        conn.enqueue(new Callback<List<NewsAdsDataModel>>() {
            @Override
            public void onResponse(Call<List<NewsAdsDataModel>> call, Response<List<NewsAdsDataModel>> response) {
                listner.onNewsAddsLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<NewsAdsDataModel>> call, Throwable t) {

                listner.onFailure("");
            }
        });
    }


}
