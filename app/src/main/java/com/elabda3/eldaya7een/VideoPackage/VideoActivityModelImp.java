package com.elabda3.eldaya7een.VideoPackage;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.VideoDataModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/9/17.
 */

public class VideoActivityModelImp implements VideoActivityModel {

    @Override
    public void getVideosFromServer(String url, final Listner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<VideoDataModel>> conn=retrofitApi.getVideos(url);
        conn.enqueue(new Callback<List<VideoDataModel>>() {
            @Override
            public void onResponse(Call<List<VideoDataModel>> call, Response<List<VideoDataModel>> response) {
                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<VideoDataModel>> call, Throwable t) {
                listner.onFailure("حدث خطأ");
            }
        });

    }
}
