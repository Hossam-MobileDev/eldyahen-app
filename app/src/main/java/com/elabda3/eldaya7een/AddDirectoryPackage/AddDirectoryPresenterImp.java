package com.elabda3.eldaya7een.AddDirectoryPackage;


import com.elabda3.eldaya7een.model.DefaultDataModel;

/**
 * Created by ebda3-mint on 10/7/17.
 */

public class AddDirectoryPresenterImp  implements AddDirectoryPresenter, AddDirectoryModel.Listner {

    AddDirectoryDialogView addDirectoryDialogView;
    AddDirectoryModelImp addDirectoryModel;

    public AddDirectoryPresenterImp(AddDirectoryDialogView addDirectoryDialogView) {
        this.addDirectoryDialogView = addDirectoryDialogView;
        addDirectoryModel=new AddDirectoryModelImp();
    }

    @Override
    public void sendDirectotyData(String name, String city, String phone) {
        addDirectoryDialogView.showProgress();
        addDirectoryModel.sendAddDirecoryToServer(name,city,phone,this);

    }

    @Override
    public void onSuccess(DefaultDataModel defaultDataModel) {
        addDirectoryDialogView.dismissProgress();
        addDirectoryDialogView.closeDialog();
    }

    @Override
    public void onFailure(String msg) {
        addDirectoryDialogView.dismissProgress();
        addDirectoryDialogView.showAlert(msg);
    }
}
