package com.elabda3.eldaya7een.aboutUsPackage;


import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.WebDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/4/17.
 */

public class AboutUsModelImp implements AboutUsModel {

    @Override
    public void getWebContentFromServer(String url, final Listner listner) {
        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<WebDataModel> conn=retrofitApi.getWebData(url);
        conn.enqueue(new Callback<WebDataModel>() {
            @Override
            public void onResponse(Call<WebDataModel> call, Response<WebDataModel> response) {
                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<WebDataModel> call, Throwable t) {
                listner.onFailure("حدث خطأ");
            }
        });
    }
}
