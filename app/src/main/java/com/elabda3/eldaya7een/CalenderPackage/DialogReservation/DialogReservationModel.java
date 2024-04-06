package com.elabda3.eldaya7een.CalenderPackage.DialogReservation;


import com.elabda3.eldaya7een.model.SocialDataModel;

/**
 * Created by ebda3-mint on 10/28/17.
 */

public interface DialogReservationModel {

    interface Listner {
        void onSuccess(SocialDataModel socialDataModel);
        void onFailure(String msg);
    }

    void getSocialFromServer(String url, Listner listner);


}
