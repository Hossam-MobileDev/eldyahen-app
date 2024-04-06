package com.elabda3.eldaya7een.CalenderPackage;

import com.elabda3.eldaya7een.model.CalenderDataModel;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by ebda3-mint on 10/8/17.
 */

public class CalenderPresenterImp implements CalenderPresenter, CalenderModel.Listner {

    CalenderView calenderView;
    CalenderModelImp calenderModelImp;
    List<CalenderDataModel> calenderDataModel=new ArrayList<>();

    public CalenderPresenterImp(CalenderView calenderView) {
        this.calenderView = calenderView;
        calenderModelImp=new CalenderModelImp();
    }

    @Override
    public void getCalenderDataFromModel() {
        calenderModelImp.getCalenderDataFromServer("http://aldaihani.org/aldaih/api.php?mod=calender",this);
    }

    @Override
    public void getCalenderEventInMonthFromModel(int month, int year) {

        calenderModelImp.getEventInMonth(calenderDataModel,month, year,this);
    }


    @Override
    public void onSuccess(List<CalenderDataModel> calenderDataModel, int month , int year) {
        calenderView.dismissProgress();
        this.calenderDataModel=calenderDataModel;
        calenderModelImp.getEventInMonth(calenderDataModel,month,year,this);

    }

    @Override
    public void onFailure(String msg) {
        calenderView.dismissProgress();
        calenderView.showAlert(msg);
    }

    @Override
    public void onFilterMonthSuccess(List<CalenderDataModel> calenderDataModel) {
        calenderView.dismissProgress();
        calenderView.initCalender(calenderDataModel);
        calenderView.initCalenderRecycler(calenderDataModel);
    }

    @Override
    public void onFilterMonthFailure(String msg) {

        calenderView.showAlert(msg);
    }
}
