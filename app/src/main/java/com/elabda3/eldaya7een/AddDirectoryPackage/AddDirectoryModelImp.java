package com.elabda3.eldaya7een.AddDirectoryPackage;

import android.text.TextUtils;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.DefaultDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/7/17.
 */

public class AddDirectoryModelImp implements AddDirectoryModel {


    @Override
    public void sendAddDirecoryToServer(String name, String city, String phone, final Listner listner) {

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(city) && !TextUtils.isEmpty(phone)) {

            RetrofitApi retrofitApi = SingletonRetrofit.getRetrofitInstant();
            Call<DefaultDataModel> conn = retrofitApi.addDirectory(name, phone, city);
            conn.enqueue(new Callback<DefaultDataModel>() {
                @Override
                public void onResponse(Call<DefaultDataModel> call, Response<DefaultDataModel> response) {
                    if(response.body().getStatus().equals("done")){
                        listner.onSuccess(response.body());
                    }else {
                        listner.onFailure(response.body().getMessage());
                    }
                }

                @Override
                public void onFailure(Call<DefaultDataModel> call, Throwable t) {

                }
            });

        }else {
            listner.onFailure("من فضلك اكمل بياناتك");
        }

    }
}
