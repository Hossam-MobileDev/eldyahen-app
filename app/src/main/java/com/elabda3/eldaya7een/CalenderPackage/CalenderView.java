package com.elabda3.eldaya7een.CalenderPackage;

import com.elabda3.eldaya7een.model.CalenderDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/8/17.
 */

public interface CalenderView {

    void showProgress();
    void dismissProgress();
    void showAlert(String msg);
    void initCalenderRecycler(List<CalenderDataModel> list);
    void initCalender(List<CalenderDataModel> list);

}
