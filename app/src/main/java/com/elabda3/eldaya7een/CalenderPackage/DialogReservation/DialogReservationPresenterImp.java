package com.elabda3.eldaya7een.CalenderPackage.DialogReservation;


import com.elabda3.eldaya7een.model.SocialDataModel;

/**
 * Created by ebda3-mint on 10/28/17.
 */

public class DialogReservationPresenterImp implements DialogReservationPresenter, DialogReservationModel.Listner {

    DialogReservationView dialogReservationView;
    DialogReservationModelImp dialogReservationModelImp;

    public DialogReservationPresenterImp(DialogReservationView dialogReservationView) {
        this.dialogReservationView = dialogReservationView;
        dialogReservationModelImp=new DialogReservationModelImp();
    }

    @Override
    public void getSocial() {
        dialogReservationView.showProgress();
        dialogReservationModelImp.getSocialFromServer("http://aldaihani.org/aldaih/api.php?mod=socialmedia",this);
    }

    @Override
    public void onSuccess(SocialDataModel socialDataModel) {
        dialogReservationView.hideProgress();
        dialogReservationView.socialLoaded(socialDataModel);
    }

    @Override
    public void onFailure(String msg) {
        dialogReservationView.hideProgress();
        dialogReservationView.fail();
    }
}
