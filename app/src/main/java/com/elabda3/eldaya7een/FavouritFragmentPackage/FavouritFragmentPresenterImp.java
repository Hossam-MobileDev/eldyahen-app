package com.elabda3.eldaya7een.FavouritFragmentPackage;

import android.content.Context;

import com.elabda3.eldaya7een.model.NewsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/9/17.
 */

public class FavouritFragmentPresenterImp implements FavouritFragmentPresenter, FavouritFragmentModel.Listner {

    FavouritFragmentView favouritFragmentView;
    FavouritFragmentModelImp favouritFragmentModelImp;

    public FavouritFragmentPresenterImp(FavouritFragmentView favouritFragmentView) {
        this.favouritFragmentView = favouritFragmentView;
        favouritFragmentModelImp=new FavouritFragmentModelImp();
    }

    @Override
    public void getFavourits(Context context) {
        favouritFragmentModelImp.getFavFromDataBase(context,this);
    }

    @Override
    public void onSuccess(List<NewsDataModel> list) {
        favouritFragmentView.dismissProgress();
        favouritFragmentView.initRecycler(list);
    }

    @Override
    public void onFailure(String msg) {
        favouritFragmentView.dismissProgress();
        favouritFragmentView.showAlert(msg);
    }
}
