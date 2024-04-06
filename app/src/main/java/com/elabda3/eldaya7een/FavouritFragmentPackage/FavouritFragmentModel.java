package com.elabda3.eldaya7een.FavouritFragmentPackage;

import android.content.Context;

import com.elabda3.eldaya7een.model.NewsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/9/17.
 */

public interface FavouritFragmentModel {

    interface Listner{

        void onSuccess(List<NewsDataModel> list);
        void onFailure(String msg);
    }

    void getFavFromDataBase(Context context, Listner listner);
}
