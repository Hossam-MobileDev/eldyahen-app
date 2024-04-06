package com.elabda3.eldaya7een.CalenderPackage.LastFiveReservationsPackage;

import com.elabda3.eldaya7een.model.CalenderDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/29/17.
 */

public interface LastFiveReservationModel {

    interface Listner{
        void onSuccess(List<CalenderDataModel> calenderDataModel);
        void onFailure(String msg);
    }

    void getCalenderDataFromServer(String url, int limit, Listner listner);

}
