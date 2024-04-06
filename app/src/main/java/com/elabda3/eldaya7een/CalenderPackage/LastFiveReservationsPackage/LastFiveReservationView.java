package com.elabda3.eldaya7een.CalenderPackage.LastFiveReservationsPackage;

import com.elabda3.eldaya7een.model.CalenderDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/29/17.
 */

public interface LastFiveReservationView {

    void showProgress();
    void hideProgress();
    void initRecycler(List<CalenderDataModel> list);


}
