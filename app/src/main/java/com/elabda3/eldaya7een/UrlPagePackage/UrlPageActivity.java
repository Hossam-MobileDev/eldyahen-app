package com.elabda3.eldaya7een.UrlPagePackage;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.hashtag.eldya7een.R;

import androidx.appcompat.app.AppCompatActivity;

public class UrlPageActivity extends AppCompatActivity implements UrlPageActivityView{
    WebView webView;
    ProgressBar progressBar;
    UrlPageActivityPresenterImp pageActivityPresenterImp;
    String url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_page);


        if(getIntent().getExtras() != null) {
            url = getIntent().getExtras().getString("url", "");

        }
        progressBar=findViewById(R.id.progress);

        webView=findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }
        });

        Log.v("url",url+">>");
        pageActivityPresenterImp=new UrlPageActivityPresenterImp(this);
        pageActivityPresenterImp.setUrl(url);
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
    public void initWebView(String url) {
        webView.loadUrl(url);
    }

}
