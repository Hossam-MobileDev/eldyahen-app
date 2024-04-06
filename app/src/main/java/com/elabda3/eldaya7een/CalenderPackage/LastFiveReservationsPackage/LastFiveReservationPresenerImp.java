package com.elabda3.eldaya7een.CalenderPackage.LastFiveReservationsPackage;

import com.elabda3.eldaya7een.model.CalenderDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/29/17.
 */

public class LastFiveReservationPresenerImp implements LastFiveReservationPresenter, LastFiveReservationModel.Listner {

    LastFiveReservationView lastFiveReservationView;
    LastFiveReservationModelImp lastFiveReservationModelImp;


    public LastFiveReservationPresenerImp(LastFiveReservationView lastFiveReservationView) {
        this.lastFiveReservationView = lastFiveReservationView;
        lastFiveReservationModelImp=new LastFiveReservationModelImp();
    }

    @Override
    public void setLastReservationLimit(String url, int limit) {
        lastFiveReservationModelImp.getCalenderDataFromServer(url,limit,this);
    }

    @Override
    public void onSuccess(List<CalenderDataModel> calenderDataModel) {
        lastFiveReservationView.hideProgress();
        lastFiveReservationView.initRecycler(calenderDataModel);
    }

    @Override
    public void onFailure(String msg) {
        lastFiveReservationView.hideProgress();

    }
}
