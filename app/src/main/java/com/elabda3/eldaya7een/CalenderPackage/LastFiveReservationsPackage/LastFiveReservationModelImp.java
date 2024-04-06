package com.elabda3.eldaya7een.CalenderPackage.LastFiveReservationsPackage;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.CalenderDataModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/29/17.
 */

public class LastFiveReservationModelImp implements LastFiveReservationModel {


    @Override
    public void getCalenderDataFromServer(String url, int limit, final Listner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<CalenderDataModel>> conn=retrofitApi.getCalenderData(url , limit);
        conn.enqueue(new Callback<List<CalenderDataModel>>() {
            @Override
            public void onResponse(Call<List<CalenderDataModel>> call, Response<List<CalenderDataModel>> response) {
                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<CalenderDataModel>> call, Throwable t) {
                listner.onFailure("");
            }
        });
    }
}
