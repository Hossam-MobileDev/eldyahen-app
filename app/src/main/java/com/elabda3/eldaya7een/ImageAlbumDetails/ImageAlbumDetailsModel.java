package com.elabda3.eldaya7een.ImageAlbumDetails;

import com.elabda3.eldaya7een.model.ImageAlbumDetailsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/9/17.
 */

public interface ImageAlbumDetailsModel {

    interface Listner{
        void onSuccess(List<ImageAlbumDetailsDataModel> list);
        void onFailure(String msg);
    }

    void getAlbumDetailsFromServer(String url, Listner listner);
}
