package com.elabda3.eldaya7een.PagePackage;


import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.PageDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/7/17.
 */

public class PageActivityModelImp implements PageActivityModel {


    @Override
    public void getPageContentFromServer(String url, final Listner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<PageDataModel> conn=retrofitApi.getPage(url);
        conn.enqueue(new Callback<PageDataModel>() {
            @Override
            public void onResponse(Call<PageDataModel> call, Response<PageDataModel> response) {
                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<PageDataModel> call, Throwable t) {
                listner.onFailure("");
            }
        });



    }
}
