package com.elabda3.eldaya7een.CalenderPackage.DialogReservation;


import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.SocialDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/28/17.
 */

public class DialogReservationModelImp implements DialogReservationModel {


    @Override
    public void getSocialFromServer(String url , final Listner listner) {
        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<SocialDataModel> conn=retrofitApi.getSocial(url);
        conn.enqueue(new Callback<SocialDataModel>() {
            @Override
            public void onResponse(Call<SocialDataModel> call, Response<SocialDataModel> response) {
                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SocialDataModel> call, Throwable t) {
            listner.onFailure("");
            }
        });
    }
}
