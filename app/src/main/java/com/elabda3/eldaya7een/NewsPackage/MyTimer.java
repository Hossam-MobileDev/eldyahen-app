package com.elabda3.eldaya7een.NewsPackage;

import android.content.Context;
import android.os.Handler;


import com.elabda3.eldaya7een.model.NewsAdsDataModel;

import java.util.List;
import java.util.TimerTask;

import androidx.viewpager.widget.ViewPager;


/**
 * Created by ebda3-mint on 10/11/17.
 */

public class MyTimer extends TimerTask {

    ViewPager viewPager;
    List<NewsAdsDataModel> list;
    Handler handler=new Handler();
    int pos = 0;
    Context context;



    public MyTimer(ViewPager viewPager ,List<NewsAdsDataModel> list) {
        this.viewPager = viewPager;
        this.list=list;
    }

    @Override
    public void run() {

        handler.post(new Runnable() {
            @Override
            public void run() {

                viewPager.setCurrentItem(pos++ % list.size());


            }
        });
    }
}
