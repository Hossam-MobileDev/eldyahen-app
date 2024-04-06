package com.elabda3.eldaya7een.FavouritFragmentPackage;

import com.elabda3.eldaya7een.model.NewsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/9/17.
 */

public interface FavouritFragmentView {


    void showProgress();
    void dismissProgress();
    void initRecycler(List<NewsDataModel> list);
    void showAlert(String msg);


}
