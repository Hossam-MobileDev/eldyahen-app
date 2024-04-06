package com.elabda3.eldaya7een.CalenderPackage;

import com.elabda3.eldaya7een.model.CalenderDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/8/17.
 */

public interface CalenderModel {

    interface Listner{
        void onSuccess(List<CalenderDataModel> calenderDataModel, int month, int year);
        void onFailure(String msg);
        void onFilterMonthSuccess(List<CalenderDataModel> calenderDataModel);
        void onFilterMonthFailure(String msg);
    }

    void getCalenderDataFromServer(String url, Listner listner);

    void getEventInMonth(List<CalenderDataModel> list, int month, int year, Listner listner);

}
