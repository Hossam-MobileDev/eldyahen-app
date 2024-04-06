package com.elabda3.eldaya7een.HomeFragmentPackage;

import android.text.TextUtils;
import android.util.Log;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.AdsDataModel;
import com.elabda3.eldaya7een.model.HomeCatsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;
import com.elabda3.eldaya7een.model.SendTokenDataModel;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public class HomeFragmentModelImp  implements HomeFragmentModel{

    String tag="HomeFragmentModelImp";

    @Override
    public void getCatsFromServer(final HomeFragmentModelListner listner) {
        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<HomeCatsDataModel>> conn=retrofitApi.getCats();
        conn.enqueue(new Callback<List<HomeCatsDataModel>>() {
            @Override
            public void onResponse(Call<List<HomeCatsDataModel>> call, Response<List<HomeCatsDataModel>> response) {

                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<HomeCatsDataModel>> call, Throwable t) {

                Log.v(tag,t.getMessage()+">");
                listner.onFailure("حدث خطأ ");
            }
        });
    }


    @Override
    public void getNewsAdds(final HomeFragmentModelListner listner) {

        RetrofitApi retrofitApi=SingletonRetrofit.getRetrofitInstant();
        Call<List<AdsDataModel>> conn=retrofitApi.getAds();
        conn.enqueue(new Callback<List<AdsDataModel>>() {
            @Override
            public void onResponse(Call<List<AdsDataModel>> call, Response<List<AdsDataModel>> response) {
                listner.onNewsAddsLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<AdsDataModel>> call, Throwable t) {

                listner.onFailure("حدث خطأ");
            }
        });
    }

    @Override
    public void getNewsAddsHorizontal(final HomeFragmentModelListner listner) {
        RetrofitApi retrofitApi=SingletonRetrofit.getRetrofitInstant();
        Call<List<NewsDataModel>> conn=retrofitApi.getNewsAds();
        conn.enqueue(new Callback<List<NewsDataModel>>() {
            @Override
            public void onResponse(Call<List<NewsDataModel>> call, Response<List<NewsDataModel>> response) {
                listner.onNewsAdsHorizontalLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<NewsDataModel>> call, Throwable t) {

                listner.onNewsAdsHorizontalFail();

            }
        });
    }


}
