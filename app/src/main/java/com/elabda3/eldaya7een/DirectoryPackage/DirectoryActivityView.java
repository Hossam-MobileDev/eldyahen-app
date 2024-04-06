package com.elabda3.eldaya7een.DirectoryPackage;

import com.elabda3.eldaya7een.model.DirectoryDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/4/17.
 */

public interface DirectoryActivityView {

    void showProgress();
    void dismissProgress();
    void showAlert(String alert);
    void initDirectoryRecycler(List<DirectoryDataModel> list);
    void openAddDirectory();


}
