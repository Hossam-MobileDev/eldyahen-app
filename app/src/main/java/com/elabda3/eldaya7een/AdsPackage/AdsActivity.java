package com.elabda3.eldaya7een.AdsPackage;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elabda3.eldaya7een.MainActivity;

import com.elabda3.eldaya7een.model.NewsAdsDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class AdsActivity extends AppCompatActivity implements View.OnClickListener,AdsView{

    TextView toolbarTitle;
    Button login;
    ViewPager viewPager;
    ProgressBar progressBar;
    AdsPresenter adsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        toolbarTitle= (TextView) findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("الإعلانات الثابتة");

        login= (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        progressBar= (ProgressBar) findViewById(R.id.progress);

        viewPager= (ViewPager) findViewById(R.id.viewPager);


        adsPresenter=new AdsPresenterImp(this);



    }

    @Override
    public void onClick(View view) {

        startActivity(new Intent(this, MainActivity.class));

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
    public void initViewPager(List<NewsAdsDataModel> list) {

        AdsViewPagerAdapter adapter=new AdsViewPagerAdapter(this,list);
        viewPager.setAdapter(adapter);

    }


}
