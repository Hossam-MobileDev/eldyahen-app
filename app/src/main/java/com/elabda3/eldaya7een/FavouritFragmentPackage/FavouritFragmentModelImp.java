package com.elabda3.eldaya7een.FavouritFragmentPackage;

import android.content.Context;
import android.util.Log;

import com.elabda3.eldaya7een.NewsDetailsPackage.SqliteHelper.SqliteHelperDB;
import com.elabda3.eldaya7een.model.NewsDataModel;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by ebda3-mint on 10/9/17.
 */

public class FavouritFragmentModelImp implements FavouritFragmentModel {

    SqliteHelperDB sqliteHelperDB;
    List<NewsDataModel> favList=new ArrayList<>();

    @Override
    public void getFavFromDataBase(Context context ,Listner listner) {
        sqliteHelperDB=new SqliteHelperDB(context);

        favList=sqliteHelperDB.getFavourits();

        Log.v("favSize",favList.size()+">>>");

        if(favList.size() > 0){
            listner.onSuccess(favList);
        }else{
            listner.onSuccess(favList );
            listner.onFailure("لا توجد اخبار في المفضلة");
        }

    }
}
