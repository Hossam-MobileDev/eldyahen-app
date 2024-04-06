package com.elabda3.eldaya7een.ImageAlbumPackage;


import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.elabda3.eldaya7een.model.AlbumDatamodel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAlbumActivity extends AppCompatActivity implements ImageAlbumView{

    TextView title;
    RecyclerView albumRecycler;
    ProgressBar progressBar;
    String url;
    ImageAlbumPresenter imageAlbumPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_album);
        title=findViewById(R.id.toolbarTitle);

        albumRecycler=findViewById(R.id.imagesRecycler);
        albumRecycler.setLayoutManager(new LinearLayoutManager(this));

        progressBar=findViewById(R.id.progress);

        if(getIntent().getExtras() != null){
            title.setText(getIntent().getExtras().getString("title",""));
            url=getIntent().getExtras().getString("url","");
        }

        imageAlbumPresenter=new ImageAlbumPresenterImp(this);
        imageAlbumPresenter.setUrl("http://aldaihani.org/aldaih/api.php?mod=photos");
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
    public void showAlert(String alert) {

        if(!TextUtils.isEmpty(alert))
            Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initImageRecycler(List<AlbumDatamodel> list) {

        AlbumAdapter albumAdapter=new AlbumAdapter(this,list);
        albumRecycler.setAdapter(albumAdapter);

    }
}
