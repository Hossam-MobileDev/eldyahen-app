package com.elabda3.eldaya7een.VideoPackage;

import com.elabda3.eldaya7een.model.VideoDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/9/17.
 */

public interface VideoActivityModel {

    interface Listner{
        void onSuccess(List<VideoDataModel> list);
        void onFailure(String msg);
    }

    void getVideosFromServer(String url, Listner listner);

}
