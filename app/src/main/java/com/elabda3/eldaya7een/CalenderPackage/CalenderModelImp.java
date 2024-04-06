package com.elabda3.eldaya7een.CalenderPackage;

import com.elabda3.eldaya7een.SingletonRetrofit;
import com.elabda3.eldaya7een.interfaces.RetrofitApi;
import com.elabda3.eldaya7een.model.CalenderDataModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ebda3-mint on 10/8/17.
 */

public class CalenderModelImp implements CalenderModel {



    @Override
    public void getCalenderDataFromServer(String url, final Listner listner) {

        Calendar calendar=Calendar.getInstance();
        final int month=calendar.get(Calendar.MONTH) + 1;
        final int year=calendar.get(Calendar.YEAR);

        RetrofitApi retrofitApi= SingletonRetrofit.getRetrofitInstant();
        Call<List<CalenderDataModel>> conn=retrofitApi.getCalenderData(url);
        conn.enqueue(new Callback<List<CalenderDataModel>>() {
            @Override
            public void onResponse(Call<List<CalenderDataModel>> call, Response<List<CalenderDataModel>> response) {
                listner.onSuccess(response.body(), month , year);
            }

            @Override
            public void onFailure(Call<List<CalenderDataModel>> call, Throwable t) {

                listner.onFailure("حدث خطأ");
            }
        });
    }

    @Override
    public void getEventInMonth(List<CalenderDataModel> list, int month , int year, Listner listner) {

        List<CalenderDataModel> filterList=new ArrayList<>();

        if(list != null) {
            for (int i = 0; i < list.size(); i++) {
                // 2016-10-11 21:00:00
                int eventMonth= Integer.parseInt( ((list.get(i).getEventdate().split(" ")[0]).
                        split("-")[1]));
                int eventYear= Integer.parseInt( ((list.get(i).getEventdate().split(" ")[0])
                        .split("-")[0]));

                if (eventMonth == month && eventYear == year) {

                    filterList.add(list.get(i));
                }
            }

            listner.onFilterMonthSuccess(filterList);
        }else{
            listner.onFilterMonthFailure("لا توجد مناسبات في هذا الشهر");
        }


    }
}
