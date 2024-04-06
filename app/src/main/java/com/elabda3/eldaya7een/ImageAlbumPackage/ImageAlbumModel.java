package com.elabda3.eldaya7een.ImageAlbumPackage;

import com.elabda3.eldaya7een.model.AlbumDatamodel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/8/17.
 */

public interface ImageAlbumModel {

    interface Listner{
        void onSuccess(List<AlbumDatamodel> list);
        void onFailure(String msg);
    }

    void getAlbumsFromServer(String url, Listner listner);

}
