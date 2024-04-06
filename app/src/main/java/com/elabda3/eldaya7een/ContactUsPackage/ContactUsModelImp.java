package com.elabda3.eldaya7een.ContactUsPackage;

import android.text.TextUtils;
import android.util.Patterns;


import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.DefaultDataModel;
import com.elabda3.eldaya7een.model.SocialDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/10/17.
 */

public class ContactUsModelImp implements ContactUsModel {

    @Override
    public void sendContactToServer(String name, String email, String msg, final Listner lister) {

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(msg)) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                RetrofitApi retrofitApi = SingletonRetrofit.getRetrofitInstant();
                Call<DefaultDataModel> conn = retrofitApi.contactUs(name, email, msg);
                conn.enqueue(new Callback<DefaultDataModel>() {
                    @Override
                    public void onResponse(Call<DefaultDataModel> call, Response<DefaultDataModel> response) {
                        if(response.body().getStatus().equals("done")) {
                            lister.onSuccess(response.body().getMessage() , true);
                        }else{
                            lister.onSuccess(response.body().getMessage() , false);
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultDataModel> call, Throwable t) {

                        lister.onFailure("حدث خطأ");
                    }
                });

            }else {
                lister.onFailure("من فضلك ادخل بريد إلكتروني بشكل صحيح");
            }
        }else {
            lister.onFailure("من فضلك أكمل بياناتك");
        }


    }

    @Override
    public void getSocail(String url, final Listner lister) {

        RetrofitApi retrofitApi=SingletonRetrofit.getRetrofitInstant();
        Call<SocialDataModel> conn=retrofitApi.getSocial(url);
        conn.enqueue(new Callback<SocialDataModel>() {
            @Override
            public void onResponse(Call<SocialDataModel> call, Response<SocialDataModel> response) {
                lister.onSocialSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SocialDataModel> call, Throwable t) {

                lister.onSocialFailure("حدث خطأ");
            }
        });

    }
}
