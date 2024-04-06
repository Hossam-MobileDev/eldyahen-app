package com.elabda3.eldaya7een.NewsDetailCommentsPackage;

import com.elabda3.eldaya7een.model.CommentsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/3/17.
 */

public class DetailsCommentPresenterImp implements DetailsCommentPresenter, DetailsCommentModel.CommentListner {

    DetailsCommentActivityView commentActivityView;
    DetailsCommentModel addCommentModel;

    public DetailsCommentPresenterImp(DetailsCommentActivityView commentActivityView) {
        this.commentActivityView = commentActivityView;
        addCommentModel=new DetailsCommentModelImp();
    }

    @Override
    public void setNewsId(String newsid) {
        commentActivityView.showProgress();
        addCommentModel.getDataFromServer(newsid,this);
    }

    @Override
    public void openAddCommentActivity() {
        commentActivityView.openAddCommentActivity();
    }

    @Override
    public void checkNoDAta(String newsid) {
        addCommentModel.noComments(newsid,this);
    }

    @Override
    public void onSuccessNoData(String noData) {
        commentActivityView.hideProgress();
        commentActivityView.showAlert(noData);
    }

    @Override
    public void onSuccess(List<CommentsDataModel> list) {
        commentActivityView.hideProgress();
        commentActivityView.initCommentsRecycler(list);
    }

    @Override
    public void onFailure(String alert) {
        commentActivityView.hideProgress();
        commentActivityView.showAlert(alert);
    }
}
