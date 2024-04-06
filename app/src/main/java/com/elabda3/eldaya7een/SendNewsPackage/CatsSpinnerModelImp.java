package com.elabda3.eldaya7een.SendNewsPackage;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import com.darsh.multipleimageselect.models.Image;
import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.CatsDataModel;
import com.elabda3.eldaya7een.model.DefaultDataModel;
import com.elabda3.eldaya7een.model.UploadNewsDataModel;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/3/17.
 */

public class CatsSpinnerModelImp implements CatsSpinnerModel {


    @Override
    public void getCatsFromServer(final Listner listner) {

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<CatsDataModel>> conn=retrofitApi.getCats("http://aldaihani.org/aldaih/api.php?mod=news");
        conn.enqueue(new Callback<List<CatsDataModel>>() {
            @Override
            public void onResponse(Call<List<CatsDataModel>> call, Response<List<CatsDataModel>> response) {

                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<CatsDataModel>> call, Throwable t) {

                listner.onFailure("حدث خطأ");
            }
        });
    }



    @Override
    public void uploadNews(String catId,String name, String email,String title, String details, String mainImagePath, final Listner listner) {



        if(!TextUtils.isEmpty(catId) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(title) && !TextUtils.isEmpty(details) && !TextUtils.isEmpty(mainImagePath)) {

            if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                File file = new File(mainImagePath);

                RequestBody catIDRequestBody = RequestBody.create(MediaType.parse("text/plain"), catId);
                RequestBody titleRequestBody = RequestBody.create(MediaType.parse("text/plain"), title);
                RequestBody detailsRequestBody = RequestBody.create(MediaType.parse("text/plain"), details);
                RequestBody nameRequestBody = RequestBody.create(MediaType.parse("text/plain"), name);
                RequestBody emailRequestBody = RequestBody.create(MediaType.parse("text/plain"), email);

                RequestBody imageRequestBody = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part iamgePart =
                        MultipartBody.Part.createFormData
                                ("imageToAttach", file.getName(), imageRequestBody);


                RetrofitApi retrofitApi = SingletonRetrofit.getRetrofitInstant();
                Call<UploadNewsDataModel> conn = retrofitApi.
                        uploadNews(catIDRequestBody, nameRequestBody, emailRequestBody,
                                titleRequestBody, detailsRequestBody, iamgePart);
                conn.enqueue(new Callback<UploadNewsDataModel>() {
                    @Override
                    public void onResponse(Call<UploadNewsDataModel> call, Response<UploadNewsDataModel> response) {
                        if (response.body().getStatus().equals("done")) {
                            listner.onNewsUploaded(response.body().getMessage(),
                                    String.valueOf(response.body().getItemid()));


                        } else {
                            listner.onFailure(response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<UploadNewsDataModel> call, Throwable t) {

                        listner.onFailure("حدث خطأ");
                    }
                });
            }else{
                listner.onFailure("من فضلك ادخل بريد إلكتروني بشكل صحيح");
            }
        }else{
            listner.onFailure("من فضلك اكمل بياناتك");
        }

    }

    @Override
    public void uploadNewsImages(final String msg , String newsid, final List<Image> list, final Listner listner) {

            for (int i = 0; i < list.size(); i++) {
                final int pos = i;
                File file = new File(list.get(i).path);
                RequestBody itemIdRequestBody = RequestBody.create(MediaType.parse("text/palin"), newsid);
                RequestBody imageRequestBody = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part imagePart = MultipartBody.Part.createFormData("photo", file.getName(), imageRequestBody);

                RetrofitApi retrofitApi = SingletonRetrofit.getRetrofitInstant();
                Call<DefaultDataModel> conn = retrofitApi.newsImages(itemIdRequestBody, imagePart);
                conn.enqueue(new Callback<DefaultDataModel>() {
                    @Override
                    public void onResponse(Call<DefaultDataModel> call, Response<DefaultDataModel> response) {
                        if (response.body().getStatus().equals("done")) {

                            Log.v("imageUploaded", response.body().getMessage() + "     " + pos);

                            if (pos == (list.size() - 1)) {
                                listner.onNewsImagesUploaded(msg);
                            }

                        } else {
                            listner.onFailure(response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultDataModel> call, Throwable t) {

                        listner.onFailure("حدث خطأ");

                    }
                });
            }



    }


}
