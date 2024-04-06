package com.elabda3.eldaya7een.AddDirectoryPackage;


import com.elabda3.eldaya7een.model.DefaultDataModel;

/**
 * Created by ebda3-mint on 10/7/17.
 */

public interface AddDirectoryModel {


    interface Listner{
        void onSuccess(DefaultDataModel defaultDataModel);
        void onFailure(String msg);
    }


    void sendAddDirecoryToServer(String name, String city, String phone, Listner listner);

}
