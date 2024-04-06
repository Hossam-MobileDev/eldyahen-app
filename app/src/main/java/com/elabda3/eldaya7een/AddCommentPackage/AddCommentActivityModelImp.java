package com.elabda3.eldaya7een.AddCommentPackage;

import android.text.TextUtils;
import android.util.Patterns;


import com.elabda3.eldaya7een.EncodeAndDecodeString.EncodeDecodeString;
import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.DefaultDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/3/17.
 */

public class AddCommentActivityModelImp implements AddCommentActivityModel {


    @Override
    public void getDataFromServer(final String newsid , String name, String email,
                                  String details, final Listner listner) {

        if (!TextUtils.isEmpty(newsid) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) &&
                !TextUtils.isEmpty(details)) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                String encodedString= EncodeDecodeString.encodeString(details);

                RetrofitApi retrofitApi = SingletonRetrofit.getRetrofitInstant();
                Call<DefaultDataModel> conn = retrofitApi.sendComment(newsid, name, email, encodedString);
                conn.enqueue(new Callback<DefaultDataModel>() {
                    @Override
                    public void onResponse(Call<DefaultDataModel> call, Response<DefaultDataModel> response) {
                        if(response.body().getStatus().equals("done")) {
                            listner.onSuccess(response.body());
                        }else {
                            listner.onFailure(response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultDataModel> call, Throwable t) {

                        listner.onFailure("حدث خطأ");
                    }
                });
            } else {
                listner.emailError("من فضلك ادخل بريد إلكتروني بشكل صحيح");
            }
        }else{
            listner.onFailure("من فضلك اكمل بياناتك");
        }

    }


}
