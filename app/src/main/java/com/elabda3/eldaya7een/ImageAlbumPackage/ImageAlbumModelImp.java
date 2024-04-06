package com.elabda3.eldaya7een.ImageAlbumPackage;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.AlbumDatamodel;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/8/17.
 */

public class ImageAlbumModelImp implements ImageAlbumModel {

    @Override
    public void getAlbumsFromServer(String url, final Listner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<AlbumDatamodel>> conn=retrofitApi.getAlbums(url);
        conn.enqueue(new Callback<List<AlbumDatamodel>>() {
            @Override
            public void onResponse(Call<List<AlbumDatamodel>> call, Response<List<AlbumDatamodel>> response) {
                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<AlbumDatamodel>> call, Throwable t) {
                listner.onFailure("");
            }
        });




    }

}
