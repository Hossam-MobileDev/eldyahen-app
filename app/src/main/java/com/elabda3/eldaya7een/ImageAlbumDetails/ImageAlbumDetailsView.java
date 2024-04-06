package com.elabda3.eldaya7een.ImageAlbumDetails;

import com.elabda3.eldaya7een.model.ImageAlbumDetailsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/9/17.
 */

public interface ImageAlbumDetailsView {

    void showProgress();
    void hideProgress();
    void showAlert(String msg);
    void setCurrentPage(int page);
    void hideImageRecycler();
    void showImageRecycler();

    void initPager(List<ImageAlbumDetailsDataModel> list);
    void initAllImagesRecycler(List<ImageAlbumDetailsDataModel> list);

}
