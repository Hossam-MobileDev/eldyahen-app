package com.elabda3.eldaya7een.ImageAlbumPackage;

import com.elabda3.eldaya7een.model.AlbumDatamodel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/8/17.
 */

public class ImageAlbumPresenterImp implements ImageAlbumPresenter, ImageAlbumModel.Listner {

    ImageAlbumView imageAlbumView;
    ImageAlbumModelImp imageAlbumModelImp;

    public ImageAlbumPresenterImp(ImageAlbumView imageAlbumView) {
        this.imageAlbumView = imageAlbumView;
        imageAlbumModelImp=new ImageAlbumModelImp();
    }

    @Override
    public void setUrl(String url) {

        imageAlbumModelImp.getAlbumsFromServer(url,this);

    }

    @Override
    public void onSuccess(List<AlbumDatamodel> list) {
        imageAlbumView.dismissProgress();
        imageAlbumView.initImageRecycler(list);
    }

    @Override
    public void onFailure(String msg) {
        imageAlbumView.dismissProgress();
        imageAlbumView.showAlert(msg);
    }
}
