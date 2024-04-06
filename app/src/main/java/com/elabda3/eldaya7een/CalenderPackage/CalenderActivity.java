package com.elabda3.eldaya7een.CalenderPackage;

import android.content.Intent;

import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.elabda3.eldaya7een.CalenderPackage.DialogReservation.DialogReservaion;
import com.elabda3.eldaya7een.CalenderPackage.LastFiveReservationsPackage.LastFiveReservationActivity;

import com.elabda3.eldaya7een.model.CalenderDataModel;
import com.hashtag.eldya7een.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CalenderActivity extends AppCompatActivity implements CalenderView, OnMonthChangedListener,
        OnDateSelectedListener {


    TextView title;
    MaterialCalendarView calendarView;
    ProgressBar progressBar;
    CalenderPresenterImp calenderPresenter;

    RecyclerView calenderRecycler;

    List<CalenderDataModel> calenderList=new ArrayList<>();

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        title=findViewById(R.id.toolbarTitle);
        title.setText("رزنامة الأفراح");

        progressBar=findViewById(R.id.progress);

        calendarView=findViewById(R.id.calender);
        calendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE);
        calendarView.setDateSelected(new Date(),true);
        calendarView.setOnMonthChangedListener(this);
        calendarView.addDecorator(new CalenderDecorate(this));
        calendarView.setOnDateChangedListener(this);



        calenderRecycler=findViewById(R.id.calenderRecycler);
        calenderRecycler.setLayoutManager(new LinearLayoutManager(this));
        calenderRecycler.setNestedScrollingEnabled(false);


        calenderPresenter=new CalenderPresenterImp(this);
        calenderPresenter.getCalenderDataFromModel();

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
    public void showAlert(String msg) {
        if(!TextUtils.isEmpty(msg))
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.last_five_reservations,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        startActivity(new Intent(this, LastFiveReservationActivity.class));

        return true;
    }

    @Override
    public void initCalenderRecycler(List<CalenderDataModel> list) {
        CalenderRecyclerAdapter calenderRecyclerAdapter=new CalenderRecyclerAdapter(this,list);
        calenderRecycler.setAdapter(calenderRecyclerAdapter);
    }

    @Override
    public void initCalender(List<CalenderDataModel> list) {
        calenderList.clear();
        calenderList=list;
        for(int i=0 ; i<list.size(); i++){
            Date date=new Date();
            String day = list.get(i).getEventdate();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            try {
                date=simpleDateFormat.parse(day);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendarView.setDateSelected(date , true);
        }
    }
    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {

        calendarView.clearSelection();

        int month=date.getMonth() + 1;
        int year=date.getYear() ;

        calenderPresenter.getCalenderEventInMonthFromModel(month,year);

    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

        String monthString="";
        String dayString="";
        boolean checkDate=true;
        if(date.getMonth() < 10){
            monthString="0"+(date.getMonth()+1);
        }else{
            monthString=(date.getMonth()+1)+"";
        }
        if(date.getDay() < 10){
            dayString="0"+date.getDay();
        }else{
            dayString=date.getDay()+"";
        }

        String selectedDate=date.getYear()+"-"+monthString+"-"+dayString;

        if(selected) {
            if (calenderList.size() != 0) {
                for (int i = 0; i < calenderList.size(); i++) {
                    Log.v("sasas", calenderList.get(i).getEventdate().split(" ")[0] + "             " +
                            selectedDate);
                    if (selectedDate.equals(calenderList.get(i).getEventdate().split(" ")[0])) {
                        checkDate = false;
                        break;
                    }
                }

                if (checkDate) {
                    startActivity(new Intent(this, DialogReservaion.class));
                }
            } else {
                startActivity(new Intent(this, DialogReservaion.class));
            }
        }


    }

}
