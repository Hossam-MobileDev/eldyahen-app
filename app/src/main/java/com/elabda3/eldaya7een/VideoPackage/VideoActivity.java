package com.elabda3.eldaya7een.VideoPackage;

import android.os.Bundle;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.elabda3.eldaya7een.model.VideoDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VideoActivity extends AppCompatActivity implements VideoActivityView {

    TextView titleTextView;
    ProgressBar progressBar;
    RecyclerView videoRecycler;

    String url="",title;

    VideoActivityPresenterImp videoActivityPresenterImp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        titleTextView=findViewById(R.id.toolbarTitle);
        progressBar=findViewById(R.id.progress);
        videoRecycler=findViewById(R.id.videoRecycler);
        videoRecycler.setLayoutManager(new LinearLayoutManager(this));

        videoActivityPresenterImp=new VideoActivityPresenterImp(this);

        if(getIntent().getExtras() != null){
            title=getIntent().getExtras().getString("title","");
            titleTextView.setText(title);

            url=getIntent().getExtras().getString("url","");
            videoActivityPresenterImp.setUrl(url);

        }


    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showAlert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initPager(List<VideoDataModel> list) {
        VideoRecyclerAdapter videoRecyclerAdapter=new VideoRecyclerAdapter(this,list);
        videoRecycler.setAdapter(videoRecyclerAdapter);
    }
}
