package com.elabda3.eldaya7een.NewsDetailsPackage;

import android.util.Log;


import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.NewsDetailsDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public class NewsDetailsModelImp implements NewsDetailsModel {


    String tag="NewsDetailsModelImp";
    NewsDetailsDataModel newsDetailsDataModel;

    @Override
    public void getNewsFromServer(String url, final NewsDetailsListner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<NewsDetailsDataModel> conn=retrofitApi.getNewsDetails(url);
        conn.enqueue(new Callback<NewsDetailsDataModel>() {
            @Override
            public void onResponse(Call<NewsDetailsDataModel> call, Response<NewsDetailsDataModel> response) {

                listner.Success(response.body());

                newsDetailsDataModel=response.body();
            }

            @Override
            public void onFailure(Call<NewsDetailsDataModel> call, Throwable t) {

                Log.v(tag,t.getMessage()+">");
                listner.failure("");
            }
        });


    }

    @Override
    public String getNewsId() {
        if(newsDetailsDataModel != null) {
            return newsDetailsDataModel.getNewsid();
        }else {
            return  "";
        }
    }
}
