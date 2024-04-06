package com.elabda3.eldaya7een.CalenderPackage.DialogReservation;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.elabda3.eldaya7een.UrlPagePackage.UrlPageActivity;
import com.elabda3.eldaya7een.model.SocialDataModel;
import com.hashtag.eldya7een.R;

import androidx.appcompat.app.AppCompatActivity;

public class DialogReservaion extends AppCompatActivity implements DialogReservationView, View.OnClickListener {

    ImageView insta,twitter;
    TextView phone;
    ProgressBar progressBar;
    ImageView close;

    TextView phone1,phone2;

    DialogReservationPresenter dialogReservationPresenter;
    SocialDataModel socialDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog_reservation);
        int width=getResources().getDisplayMetrics().widthPixels;
        width=width-50;

        float denisty=getResources().getDisplayMetrics().density;
        int height=(int)(270*denisty);

        getWindow().setLayout(width, height);

        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        close=findViewById(R.id.close);
        close.setOnClickListener(this);

        insta=findViewById(R.id.insta);
        insta.setOnClickListener(this);

        twitter=findViewById(R.id.twitter);
        twitter.setOnClickListener(this);


        progressBar=findViewById(R.id.progress);
        phone1=findViewById(R.id.phone1);
        phone1.setOnClickListener(this);
        phone2=findViewById(R.id.phone2);
        phone2.setOnClickListener(this);

        dialogReservationPresenter=new DialogReservationPresenterImp(this);
        dialogReservationPresenter.getSocial();
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
    public void socialLoaded(SocialDataModel socialDataModel) {
        this.socialDataModel=socialDataModel;
        phone1.setText(socialDataModel.getLat());
        phone2.setText(socialDataModel.getLongX());
    }

    @Override
    public void fail() {
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.close:
                finish();
                break;
            case R.id.insta:
                if(socialDataModel != null) {
                    Intent intent = new Intent(this, UrlPageActivity.class);
                    intent.putExtra("url", "http://instagram.com/" + socialDataModel.getInstagram());
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.twitter:
                if(socialDataModel != null) {
                    Intent intent=new Intent(this, UrlPageActivity.class);
                    intent.putExtra("url","https://twitter.com/"+socialDataModel.getTwitter());
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.phone1:
                if(socialDataModel != null) {
                    Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+socialDataModel.getLat()));
                    startActivity(intent);
                }
                break;

            case R.id.phone2:
                if(socialDataModel != null) {
                    Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+socialDataModel.getLongX()));
                    startActivity(intent);
                }
                break;

        }
    }
}
