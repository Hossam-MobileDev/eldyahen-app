package com.elabda3.eldaya7een.AdsPackage;

import android.util.Log;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.NewsAdsDataModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public class AdsModelImp implements AdsModel {


    @Override
    public void getAdsFromServer(String url, final AdsListner listner) {
        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<NewsAdsDataModel>> conn=retrofitApi.getNewsAds(url);
        conn.enqueue(new Callback<List<NewsAdsDataModel>>() {
            @Override
            public void onResponse(Call<List<NewsAdsDataModel>> call, Response<List<NewsAdsDataModel>> response) {
                Log.v("AdsModelImp",response.body().get(0).getFileurl());
                listner.adsLoaded(response.body());

            }

            @Override
            public void onFailure(Call<List<NewsAdsDataModel>> call, Throwable t) {
                Log.v("AdsModelImp",t.getMessage());
                listner.fail();

            }
        });
    }


}
