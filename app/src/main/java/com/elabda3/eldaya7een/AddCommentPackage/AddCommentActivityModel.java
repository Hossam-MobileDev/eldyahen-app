package com.elabda3.eldaya7een.AddCommentPackage;


import com.elabda3.eldaya7een.model.DefaultDataModel;

/**
 * Created by ebda3-mint on 10/3/17.
 */

public interface AddCommentActivityModel {

    interface Listner{

        void onSuccess(DefaultDataModel result);
        void onFailure(String alert);
        void emailError(String alert);
    }

    void getDataFromServer(String newsid, String name, String email, String details, Listner listner);

}
