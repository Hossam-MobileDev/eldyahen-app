package com.elabda3.eldaya7een.DirectoryPackage;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.DirectoryDataModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/4/17.
 */

public class DirectoryModelImp implements DirectoryModel {



    @Override
    public void getDirectoriesFromServer(String url, final Listner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<DirectoryDataModel>> conn=retrofitApi.getDir(url);
        conn.enqueue(new Callback<List<DirectoryDataModel>>() {
            @Override
            public void onResponse(Call<List<DirectoryDataModel>> call, Response<List<DirectoryDataModel>> response) {
                listner.onSucess(response.body());
            }

            @Override
            public void onFailure(Call<List<DirectoryDataModel>> call, Throwable t) {

                listner.onFailure("");
            }
        });
    }
}
