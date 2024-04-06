package com.elabda3.eldaya7een.DirectoryPackage;

import com.elabda3.eldaya7een.model.DirectoryDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/4/17.
 */

public class DirectoryPresenterImp implements DirectoryPresenter ,DirectoryModel.Listner {

    DirectoryActivityView directoryActivityView;
    DirectoryModel directoryModel;

    public DirectoryPresenterImp(DirectoryActivityView directoryActivityView) {
        this.directoryActivityView = directoryActivityView;
        directoryModel=new DirectoryModelImp();
        directoryModel.getDirectoriesFromServer("http://aldaihani.org/aldaih/api.php?mod=dir",this);
    }


    @Override
    public void onSucess(List<DirectoryDataModel> list) {
        directoryActivityView.dismissProgress();
        directoryActivityView.initDirectoryRecycler(list);
    }

    @Override
    public void onFailure(String alert) {
        directoryActivityView.dismissProgress();
        directoryActivityView.showAlert(alert);
    }

    @Override
    public void navigateToOpenAddDirecoryDialog() {
        directoryActivityView.openAddDirectory();
    }
}
