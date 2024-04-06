package com.elabda3.eldaya7een.ImageAlbumDetails;

/**
 * Created by ebda3-mint on 10/9/17.
 */

public interface ImageAlbumDetailsPresenter {

    void getAlbumDetailsFromModel(String url);

    void setCurrentViewPager(int page);

    void showImageRecycler();
    void hideImageRecycler();

}
