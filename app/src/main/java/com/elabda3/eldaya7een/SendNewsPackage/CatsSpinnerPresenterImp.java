package com.elabda3.eldaya7een.SendNewsPackage;

import com.darsh.multipleimageselect.models.Image;
import com.elabda3.eldaya7een.model.CatsDataModel;

import java.util.List;


/**
 * Created by ebda3-mint on 10/3/17.
 */

public class CatsSpinnerPresenterImp implements CatsSpinnerPresenter ,CatsSpinnerModel.Listner {


    SendNewsView sendNewsView;
    CatsSpinnerModel catsSpinnerModel;
    List<Image> imageList;

    public CatsSpinnerPresenterImp(SendNewsView sendNewsView) {
        this.sendNewsView = sendNewsView;
        catsSpinnerModel=new CatsSpinnerModelImp();
        catsSpinnerModel.getCatsFromServer(this);
    }


    @Override
    public void onSuccess(List<CatsDataModel> list) {
        sendNewsView.hidePogress();
        sendNewsView.initSpinner(list);
    }

    @Override
    public void onFailure(String alert) {
        sendNewsView.hidePogress();
        sendNewsView.showAlert(alert);
    }

    @Override
    public void onNewsUploaded(String msg,String newsid) {
        if(imageList != null) {
            catsSpinnerModel.uploadNewsImages(msg, newsid, imageList, this);
        }else {
            sendNewsView.hidePogress();
            sendNewsView.newsUploaded(msg);
        }

    }


    @Override
    public void onNewsImagesUploaded(String msg) {
        sendNewsView.hidePogress();
        sendNewsView.newsUploaded(msg);
    }

    @Override
    public void sendNewsData(String catId,String name ,String email, String title, String details, String mainImagePath) {
        sendNewsView.showProgress();
        catsSpinnerModel.uploadNews(catId,name,email, title, details, mainImagePath,this);
    }

    @Override
    public void setNewsImages(List<Image> images) {
        this.imageList=images;
        sendNewsView.initImageRecycler(imageList);
    }
}
