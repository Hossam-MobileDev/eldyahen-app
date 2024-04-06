package com.elabda3.eldaya7een.ImageAlbumPackage;

import com.elabda3.eldaya7een.model.AlbumDatamodel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/8/17.
 */

public interface ImageAlbumView {

    void showProgress();
    void dismissProgress();
    void showAlert(String alert);
    void initImageRecycler(List<AlbumDatamodel> list);


}
