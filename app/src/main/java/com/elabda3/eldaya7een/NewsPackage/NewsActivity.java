package com.elabda3.eldaya7een.NewsPackage;


import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.eftimoff.viewpagertransformers.CubeOutTransformer;

import com.elabda3.eldaya7een.model.NewsAdsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;
import com.hashtag.eldya7een.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class NewsActivity extends AppCompatActivity implements NewsActivityView{


    TextView toolbarTitle;
    RecyclerView newsRecycler;
    String titleString="",url="";
    ProgressBar progressBar;

    LinearLayoutManager linearLayoutManager;

    NewsPresenter newsPresenter;

    ViewPager viewPager;

    int page=1 ,scrollValue=0;
    List<NewsDataModel> allNewsList = new ArrayList<>();

    PullRefreshLayout refreshLayout;
    NewsActivityAdapter newsActivityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news2);
        if(getIntent().getExtras() != null){
            titleString=getIntent().getExtras().getString("title","الاخبار");
            url=getIntent().getExtras().getString("url","");
        }

        progressBar=findViewById(R.id.progress);

        toolbarTitle=findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(titleString);

        refreshLayout=findViewById(R.id.swipeRefreshLayout);

        refreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page=1;
                scrollValue=0;
                allNewsList.clear();
                newsActivityAdapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(true);
                newsPresenter.setNewsUrl(url,page);
            }
        });

        initRecycler();




        viewPager=findViewById(R.id.viewPager);
        float density = getResources().getDisplayMetrics().density;
        int dp = (int)(50 / density);
        viewPager.setPageMargin(dp);

        newsPresenter=new NewsPresenterImp(this);
        newsPresenter.setNewsUrl(url,page);


    }

    private void initRecycler() {
        newsRecycler = findViewById(R.id.newsRecycler);
        linearLayoutManager = new LinearLayoutManager(this);
        newsRecycler.setLayoutManager(linearLayoutManager);
        newsRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                int numOfItems = linearLayoutManager.getChildCount();
                int allnumOfItems = linearLayoutManager.getItemCount();
                int firstComplete = linearLayoutManager.findFirstCompletelyVisibleItemPosition();

                if ((firstComplete + numOfItems) >= allnumOfItems) {

                    ++page;
                    newsPresenter.setNewsUrl(url, page);
                }

            }
        });


    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        refreshLayout.setRefreshing(false);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void initNewsRecycler(List<NewsDataModel> list) {

        allNewsList.addAll(list);
        newsActivityAdapter=new NewsActivityAdapter(this,allNewsList);
        newsRecycler.setAdapter(newsActivityAdapter);

        int scrolltoP=scrollValue*list.size();

        newsRecycler.scrollToPosition(scrolltoP);

        scrollValue++;

    }

    @Override
    public void initViewPager(final List<NewsAdsDataModel> list) {
        NewsPagerAdapter viewPagerAdapter=new NewsPagerAdapter(this,list);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setPageTransformer(false,new CubeOutTransformer());

        try {

            MyTimer myTimer = new MyTimer(viewPager, list);

            new Timer().scheduleAtFixedRate(myTimer, 0, 10000);

        }catch (Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void showAlert(String alert) {
        if(!TextUtils.isEmpty(alert))
            Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nextAds(int pos) {

        viewPager.setCurrentItem(pos);

    }
}
