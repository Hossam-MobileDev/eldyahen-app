package com.elabda3.eldaya7een.CalenderDetailsPackage;


import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;


import com.hashtag.eldya7een.R;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class CalenderDetailsActivity extends AppCompatActivity {

    TextView title;
    ImageView detailsImage;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_details);

        title=findViewById(R.id.toolbarTitle);
        detailsImage=findViewById(R.id.calenderImage);
        webView=findViewById(R.id.webView);


        if(getIntent().getExtras() != null){
            title.setText(getIntent().getExtras().getString("title",""));
            Picasso.with(this).load(getIntent().getExtras().getString("photo","")).into(detailsImage);
            webView.loadData(getIntent().getExtras().getString("content",""),"text/html ; charset=utf-8","UTF-8");
        }


    }
    }

