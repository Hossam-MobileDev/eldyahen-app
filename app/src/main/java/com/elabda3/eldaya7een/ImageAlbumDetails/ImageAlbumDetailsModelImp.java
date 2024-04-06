package com.elabda3.eldaya7een.ImageAlbumDetails;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.ImageAlbumDetailsDataModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/9/17.
 */

public class ImageAlbumDetailsModelImp implements ImageAlbumDetailsModel {

    @Override
    public void getAlbumDetailsFromServer(String url, final Listner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<ImageAlbumDetailsDataModel>> conn=retrofitApi.getAlbumsDetails(url);
        conn.enqueue(new Callback<List<ImageAlbumDetailsDataModel>>() {
            @Override
            public void onResponse(Call<List<ImageAlbumDetailsDataModel>> call, Response<List<ImageAlbumDetailsDataModel>> response) {
                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<ImageAlbumDetailsDataModel>> call, Throwable t) {

                listner.onFailure("");
            }
        });
    }
}
