package com.elabda3.eldaya7een;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.elabda3.eldaya7een.ContactUsPackage.ContactUsFragment;
import com.elabda3.eldaya7een.FavouritFragmentPackage.FavouritFragment;
import com.elabda3.eldaya7een.HomeFragmentPackage.HomeFragment;
import com.elabda3.eldaya7een.SendNewsPackage.SendNews;
import com.elabda3.eldaya7een.aboutUsPackage.AboutUsFragment;
import com.hashtag.eldya7een.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView aboutsUs,fav,sendNews,contactUs,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home=findViewById(R.id.home);
        home.setOnClickListener(this);

        contactUs=findViewById(R.id.contactUs);
        contactUs.setOnClickListener(this);

        sendNews=findViewById(R.id.sendNews);
        sendNews.setOnClickListener(this);

        fav=findViewById(R.id.fav);
        fav.setOnClickListener(this);

        aboutsUs=findViewById(R.id.aboutUs);
        aboutsUs.setOnClickListener(this);
        HomeSelected();

        getSupportFragmentManager().beginTransaction().
                replace(R.id.container,new HomeFragment()).commit();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.home:
                HomeSelected();
               getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                break;
            case R.id.sendNews:
                sendNewsSelected();
              getSupportFragmentManager().beginTransaction().replace(R.id.container, new SendNews()).commit();
                break;
            case R.id.fav:
                favouritsSelected();
                FavouritFragment favouritFragment = new FavouritFragment();
                Bundle bundle = new Bundle();
                bundle.putString("title", "المفضلة");
                favouritFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, favouritFragment).commit();
                break;
            case R.id.aboutUs:
                aboutUsSelected();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new AboutUsFragment())
                        .commit();
                break;
            case R.id.contactUs:
                contactUs();
               getSupportFragmentManager().beginTransaction().replace(R.id.container, new ContactUsFragment())
                       .commit();
                break;
        }
    }

    private void HomeSelected(){
        home.setImageResource(R.drawable.home_selected);
        contactUs.setImageResource(R.drawable.mail);
        sendNews.setImageResource(R.drawable.sendnews);
        fav.setImageResource(R.drawable.fav);
        aboutsUs.setImageResource(R.drawable.aboutus);

    }

    private void sendNewsSelected(){
        home.setImageResource(R.drawable.home);
        contactUs.setImageResource(R.drawable.mail);
        sendNews.setImageResource(R.drawable.sendnews_selected);
        fav.setImageResource(R.drawable.fav);
        aboutsUs.setImageResource(R.drawable.aboutus);

    }

    private void contactUs(){
        home.setImageResource(R.drawable.home);
        contactUs.setImageResource(R.drawable.mail_slected);
        sendNews.setImageResource(R.drawable.sendnews);
        fav.setImageResource(R.drawable.fav);
        aboutsUs.setImageResource(R.drawable.aboutus);

    }

    private void aboutUsSelected(){
        home.setImageResource(R.drawable.home);
        contactUs.setImageResource(R.drawable.mail);
        sendNews.setImageResource(R.drawable.sendnews);
        fav.setImageResource(R.drawable.fav);
        aboutsUs.setImageResource(R.drawable.aboutus_selected);

    }

    private void favouritsSelected(){
        home.setImageResource(R.drawable.home);
        contactUs.setImageResource(R.drawable.mail);
        sendNews.setImageResource(R.drawable.sendnews);
        fav.setImageResource(R.drawable.fav_selected);
        aboutsUs.setImageResource(R.drawable.aboutus);

    }
}
