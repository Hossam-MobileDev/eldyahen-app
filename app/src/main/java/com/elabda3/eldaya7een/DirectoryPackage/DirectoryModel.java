package com.elabda3.eldaya7een.DirectoryPackage;

import com.elabda3.eldaya7een.model.DirectoryDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/4/17.
 */

public interface DirectoryModel {

    interface Listner{
        void onSucess(List<DirectoryDataModel> list);
        void  onFailure(String alert);
    }

    void getDirectoriesFromServer(String url, Listner listner);

}
