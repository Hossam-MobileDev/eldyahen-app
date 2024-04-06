package com.elabda3.eldaya7een.VideoPackage;

import com.elabda3.eldaya7een.model.VideoDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/9/17.
 */

public interface VideoActivityView {

    void showProgress();
    void dismissProgress();
    void showAlert(String msg);
    void initPager(List<VideoDataModel> list);


}
