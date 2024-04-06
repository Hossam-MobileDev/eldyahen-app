package com.elabda3.eldaya7een.ImageAlbumDetails;


import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.eftimoff.viewpagertransformers.CubeOutTransformer;

import com.elabda3.eldaya7een.model.ImageAlbumDetailsDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class ImageAlbumDetailsActivity extends AppCompatActivity implements ImageAlbumDetailsView{


    TextView title;
    ViewPager albumPager;
    ProgressBar progressBar;

    ImageAlbumDetailsPresenterImp imageAlbumDetailsPresenterImp;
    String url="";

    RecyclerView imagesRecyclerScroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_album_details);

        title=findViewById(R.id.toolbarTitle);
        title.setText("البوم الصور");

        progressBar=findViewById(R.id.progress);

        imagesRecyclerScroll=findViewById(R.id.imagesRecyclerScroll);
        imagesRecyclerScroll.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        albumPager=findViewById(R.id.albumPager);
        albumPager.setClipToPadding(false);

//        float dp=getResources().getDisplayMetrics().density;
//        int margin=(int)(50/dp);
//        albumPager.setPageMargin(margin);

        albumPager.setPageTransformer(false, new CubeOutTransformer());


        imageAlbumDetailsPresenterImp=new ImageAlbumDetailsPresenterImp(this);

        if(getIntent().getExtras() != null) {
            url=getIntent().getExtras().getString("url","");
            imageAlbumDetailsPresenterImp.getAlbumDetailsFromModel(url);
        }

    }
    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showAlert(String msg) {

        if(!TextUtils.isEmpty(msg))
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCurrentPage(int page) {
        albumPager.setCurrentItem(page);
    }

    @Override
    public void hideImageRecycler() {
        imagesRecyclerScroll.setVisibility(View.GONE);
    }

    @Override
    public void showImageRecycler() {
        imagesRecyclerScroll.setVisibility(View.VISIBLE);
    }

    @Override
    public void initPager(List<ImageAlbumDetailsDataModel> list) {

        ImageAlbumDetailsPagerAdapter albumDetailsPagerAdapter=new ImageAlbumDetailsPagerAdapter(this,list,imageAlbumDetailsPresenterImp);
        albumPager.setAdapter(albumDetailsPagerAdapter);
    }

    @Override
    public void initAllImagesRecycler(List<ImageAlbumDetailsDataModel> list) {
        AllImagesRecyclerAdapter allImagesRecyclerAdapter=new AllImagesRecyclerAdapter(this,list ,imageAlbumDetailsPresenterImp);
        imagesRecyclerScroll.setAdapter(allImagesRecyclerAdapter);
    }

}
