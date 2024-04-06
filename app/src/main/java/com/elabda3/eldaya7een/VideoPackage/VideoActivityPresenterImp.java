package com.elabda3.eldaya7een.VideoPackage;

import com.elabda3.eldaya7een.model.VideoDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/9/17.
 */

public class VideoActivityPresenterImp implements VideoActivityPresenter, VideoActivityModel.Listner {

    VideoActivityView videoActivityView;
    VideoActivityModelImp videoActivityModelImp;

    public VideoActivityPresenterImp(VideoActivityView videoActivityView) {
        this.videoActivityView = videoActivityView;
        videoActivityModelImp=new VideoActivityModelImp();
    }

    @Override
    public void setUrl(String url) {
        videoActivityModelImp.getVideosFromServer(url,this);
    }

    @Override
    public void onSuccess(List<VideoDataModel> list) {
        videoActivityView.dismissProgress();
        videoActivityView.initPager(list);
    }

    @Override
    public void onFailure(String msg) {
        videoActivityView.dismissProgress();
        videoActivityView.showAlert(msg);
    }
}
