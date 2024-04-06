package com.elabda3.eldaya7een.CalenderPackage.LastFiveReservationsPackage;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elabda3.eldaya7een.CalenderPackage.CalenderRecyclerAdapter;

import com.elabda3.eldaya7een.model.CalenderDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LastFiveReservationActivity extends AppCompatActivity implements LastFiveReservationView {

    TextView title;
    RecyclerView lastFiveReservationRecycler;
    ProgressBar progressBar;

    LastFiveReservationPresenerImp lastFiveReservationPresenerImp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_five_reservation);
        title=findViewById(R.id.toolbarTitle);
        title.setText("أخر 5 حجوزات");

        progressBar=findViewById(R.id.progress);

        lastFiveReservationRecycler=findViewById(R.id.lastFiveReservationRecycler);
        lastFiveReservationRecycler.setLayoutManager(new LinearLayoutManager(this));

        lastFiveReservationPresenerImp=new LastFiveReservationPresenerImp(this);
        lastFiveReservationPresenerImp.setLastReservationLimit("http://aldaihani.org/aldaih/api.php?mod=calender",5);
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
    public void initRecycler(List<CalenderDataModel> list) {
        CalenderRecyclerAdapter calenderRecyclerAdapter=new CalenderRecyclerAdapter(this,list);
        lastFiveReservationRecycler.setAdapter(calenderRecyclerAdapter);
    }
}
