package com.elabda3.eldaya7een.NewsDetailCommentsPackage;

import android.util.Log;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.CommentsDataModel;
import com.elabda3.eldaya7een.model.DefaultDataModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/3/17.
 */

public class DetailsCommentModelImp implements DetailsCommentModel {

    String tag="DetailsCommentModelImp";

    @Override
    public void getDataFromServer(final String newsid, final CommentListner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<CommentsDataModel>> conn=retrofitApi.getComments(newsid);
        conn.enqueue(new Callback<List<CommentsDataModel>>() {
            @Override
            public void onResponse(Call<List<CommentsDataModel>> call, Response<List<CommentsDataModel>> response) {
                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<CommentsDataModel>> call, Throwable t) {

                listner.checkNoDAta(newsid);
            }
        });

    }

    @Override
    public void noComments(String newsid, final CommentListner listner) {
        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<DefaultDataModel> conn=retrofitApi.noComments(newsid);
        conn.enqueue(new Callback<DefaultDataModel>() {
            @Override
            public void onResponse(Call<DefaultDataModel> call, Response<DefaultDataModel> response) {
                listner.onSuccessNoData(response.body().getMessage());

            }

            @Override
            public void onFailure(Call<DefaultDataModel> call, Throwable t) {
                Log.v(tag,t.getMessage());
                listner.onFailure("حدث خطأ");
            }
        });
    }
}
