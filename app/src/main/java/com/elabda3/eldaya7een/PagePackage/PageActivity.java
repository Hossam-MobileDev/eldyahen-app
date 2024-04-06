package com.elabda3.eldaya7een.PagePackage;

import android.content.Intent;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.elabda3.eldaya7een.SendSMSPackage.SendSmsActivity;
import com.elabda3.eldaya7een.model.PageDataModel;
import com.hashtag.eldya7een.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PageActivity extends AppCompatActivity implements PageActivityView {

    TextView title;
    WebView webView;
    ProgressBar progressBar;
    PageActivityPresenterImp pageActivityPresenterImp;
    String url="";
    String pageId="";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        title=findViewById(R.id.toolbarTitle);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if(getIntent().getExtras() != null){
            title.setText(getIntent().getExtras().getString("title",""));
            url=getIntent().getExtras().getString("url","");
            pageId=getIntent().getExtras().getString("pageid","");

        }

        progressBar=findViewById(R.id.progress);

        webView=findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        pageActivityPresenterImp=new PageActivityPresenterImp(this);
        pageActivityPresenterImp.setUrl(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if(pageId.equals("27")){

            getMenuInflater().inflate(R.menu.send_sms,menu);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        startActivity(new Intent(this, SendSmsActivity.class));
        return true;
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
        Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initWebViewWithData(PageDataModel pageDataModel) {
        webView.loadData(pageDataModel.getContent(),"text/html ; charset=utf-8","UTF-8");
    }
}
