package com.elabda3.eldaya7een.SendSMSPackage;

import android.util.Log;


import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.SendSmsDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/28/17.
 */

public class SendSmsModelImp implements SendSmsModel {


    @Override
    public void sendSmsToServer(String senderPhone, String deliverdPhone, String msg, String date , final Listner listner) {
        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<SendSmsDataModel> conn=retrofitApi.sendSms(senderPhone,deliverdPhone,msg,date);
        conn.enqueue(new Callback<SendSmsDataModel>() {
            @Override
            public void onResponse(Call<SendSmsDataModel> call, Response<SendSmsDataModel> response) {
                if(response.body().getStatus().equals("done")){
                    listner.onSuccess(response.body());
                }else{
                    listner.onFailure(response.body().getMessage());
                }

            }

            @Override
            public void onFailure(Call<SendSmsDataModel> call, Throwable t) {

                Log.v("ssss",t.getMessage()+">>>");
            }
        });
    }
}
