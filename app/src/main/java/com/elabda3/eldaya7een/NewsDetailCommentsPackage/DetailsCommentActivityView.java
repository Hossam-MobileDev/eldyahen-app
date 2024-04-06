package com.elabda3.eldaya7een.NewsDetailCommentsPackage;

import com.elabda3.eldaya7een.model.CommentsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/3/17.
 */

public interface DetailsCommentActivityView {

    void showProgress();
    void hideProgress();
    void showAlert(String alert);
    void initCommentsRecycler(List<CommentsDataModel> comments);
    void openAddCommentActivity();


}
