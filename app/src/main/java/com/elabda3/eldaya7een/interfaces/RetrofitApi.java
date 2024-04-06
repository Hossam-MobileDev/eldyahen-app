package com.elabda3.eldaya7een.interfaces;

import com.elabda3.eldaya7een.model.AdsDataModel;
import com.elabda3.eldaya7een.model.AlbumDatamodel;
import com.elabda3.eldaya7een.model.CalenderDataModel;
import com.elabda3.eldaya7een.model.CatsDataModel;
import com.elabda3.eldaya7een.model.CommentsDataModel;
import com.elabda3.eldaya7een.model.DefaultDataModel;
import com.elabda3.eldaya7een.model.DirectoryDataModel;
import com.elabda3.eldaya7een.model.HomeCatsDataModel;
import com.elabda3.eldaya7een.model.ImageAlbumDetailsDataModel;
import com.elabda3.eldaya7een.model.NewsAdsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;
import com.elabda3.eldaya7een.model.NewsDetailsDataModel;
import com.elabda3.eldaya7een.model.PageDataModel;
import com.elabda3.eldaya7een.model.SendSmsDataModel;
import com.elabda3.eldaya7een.model.SendTokenDataModel;
import com.elabda3.eldaya7een.model.SocialDataModel;
import com.elabda3.eldaya7een.model.UploadNewsDataModel;
import com.elabda3.eldaya7een.model.VideoDataModel;
import com.elabda3.eldaya7een.model.WebDataModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;


/**
 * Created by ebda3-mint on 10/2/17.
 */

public interface RetrofitApi {

    @GET("api.php?mod=newsslider")
    Call<List<AdsDataModel>> getAds();

    @GET("api.php?mod=menu1")
    Call<List<HomeCatsDataModel>> getCats();

    @GET
    Call<List<NewsDataModel>> getNews(@Url String url, @Query("page") int page);

    @GET
    Call<DefaultDataModel> getNoNews(@Url String url, @Query("page") int page);


    @GET
    Call<NewsDetailsDataModel> getNewsDetails(@Url String url);

    @GET("api.php?mod=comments")
    Call<List<CommentsDataModel>> getComments(@Query("newsid") String newsid);

    @FormUrlEncoded
    @POST("api.php?mod=commentadd")
    Call<DefaultDataModel> sendComment(@Field("newsid") String newsid,
                                       @Field("username") String username,
                                       @Field("email") String email,
                                       @Field("content") String content
    );

    @GET
    Call<List<CatsDataModel>> getCats(@Url String url);

    @Multipart
    @POST("api.php?mod=addnews")
    Call<UploadNewsDataModel> uploadNews(@Part("categoryid") RequestBody categoryid,
                                         @Part("writer") RequestBody writer,
                                         @Part("phone") RequestBody phone,
                                         @Part("title") RequestBody title,
                                         @Part("description") RequestBody description,
                                         @Part MultipartBody.Part imageToAttach);

    @Multipart
    @POST("api.php?mod=addphoto")
    Call<DefaultDataModel> newsImages(@Part("itemid") RequestBody itemid,
                                      @Part MultipartBody.Part photo);

    @GET("api.php?mod=comments")
    Call<DefaultDataModel> noComments(@Query("newsid") String newsid);

    @GET
    Call<List<NewsAdsDataModel>> getNewsAds(@Url String url);

    @GET
    Call<List<DirectoryDataModel>> getDir(@Url String url);

    @GET
    Call<WebDataModel> getWebData(@Url String url);

    @FormUrlEncoded
    @POST("api.php?mod=diradd")
    Call<DefaultDataModel> addDirectory(@Field("name") String name,
                                        @Field("phone") String phone,
                                        @Field("location") String location
    );
    @GET
    Call<PageDataModel> getPage(@Url String url);

    @GET
    Call<List<CalenderDataModel>> getCalenderData(@Url String url);

    @GET
    Call<List<CalenderDataModel>> getCalenderData(@Url String url, @Query("limit") int limit);

    @GET
    Call<List<AlbumDatamodel>> getAlbums(@Url String url);

    @GET
    Call<List<ImageAlbumDetailsDataModel>> getAlbumsDetails(@Url String url);

    @GET
    Call<List<VideoDataModel>> getVideos(@Url String url);


    @FormUrlEncoded
    @POST("api.php?mod=contactus")
    Call<DefaultDataModel> contactUs(@Field("name") String name,
                                     @Field("email") String email,
                                     @Field("message") String message

    );

    @GET
    Call<SocialDataModel> getSocial(@Url String url);

    @GET("api.php?mod=android")
    Call<SendTokenDataModel> sendToken(@Query("token") String token);

    @FormUrlEncoded
    @POST("api.php?mod=sendsmsmessage")
    Call<SendSmsDataModel> sendSms(@Field("sender") String sender,
                                   @Field("receiver") String receiver,
                                   @Field("msg") String msg,
                                   @Field("smsdate") String smsdate
    );

    @GET("api.php?mod=")
    Call<List<NewsDataModel>> getNewsAds();

}
