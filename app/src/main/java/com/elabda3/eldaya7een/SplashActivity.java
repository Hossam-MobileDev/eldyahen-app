package com.elabda3.eldaya7een;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.widget.ImageView;

import com.hashtag.eldya7een.R;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    ImageView splashImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashImage= (ImageView) findViewById(R.id.splash);
        Picasso.with(this).load(R.drawable.splash).fit().into(splashImage);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //startActivity(new Intent(SplashActivity.this, AdsActivity.class));

                startActivity
                        (new Intent(SplashActivity.this,
                                MainActivity.class));
                finish();

            }
        },4000);

    }
    }
