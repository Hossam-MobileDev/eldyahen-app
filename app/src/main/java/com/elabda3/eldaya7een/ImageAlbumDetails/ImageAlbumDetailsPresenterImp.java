package com.elabda3.eldaya7een.ImageAlbumDetails;

import com.elabda3.eldaya7een.model.ImageAlbumDetailsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/9/17.
 */

public class ImageAlbumDetailsPresenterImp implements ImageAlbumDetailsPresenter, ImageAlbumDetailsModel.Listner {

    ImageAlbumDetailsView imageAlbumDetailsView;
    ImageAlbumDetailsModelImp imageAlbumDetailsModelImp;

    public ImageAlbumDetailsPresenterImp(ImageAlbumDetailsView imageAlbumDetailsView) {
        this.imageAlbumDetailsView = imageAlbumDetailsView;
        imageAlbumDetailsModelImp=new ImageAlbumDetailsModelImp();
    }

    @Override
    public void getAlbumDetailsFromModel(String url) {
        imageAlbumDetailsModelImp.getAlbumDetailsFromServer(url,this);

    }

    @Override
    public void setCurrentViewPager(int page) {
        imageAlbumDetailsView.setCurrentPage(page);
    }

    @Override
    public void showImageRecycler() {
        imageAlbumDetailsView.showImageRecycler();
    }

    @Override
    public void hideImageRecycler() {
        imageAlbumDetailsView.hideImageRecycler();
    }

    @Override
    public void onSuccess(List<ImageAlbumDetailsDataModel> list) {
        imageAlbumDetailsView.hideProgress();
        imageAlbumDetailsView.initPager(list);
        imageAlbumDetailsView.initAllImagesRecycler(list);
    }

    @Override
    public void onFailure(String msg) {
        imageAlbumDetailsView.hideProgress();
        imageAlbumDetailsView.showAlert(msg);
    }
}
