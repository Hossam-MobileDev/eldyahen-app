package com.elabda3.eldaya7een.AddCommentPackage;


import com.elabda3.eldaya7een.model.DefaultDataModel;

/**
 * Created by ebda3-mint on 10/3/17.
 */

public class AddCommentActivityPresenterImp implements AddCommentActivityPresenter, AddCommentActivityModel.Listner {

    AddCommentActivityView addCommentActivityView;
    AddCommentActivityModel addCommentActivityModel;

    public AddCommentActivityPresenterImp(AddCommentActivityView addCommentActivityView) {
        this.addCommentActivityView = addCommentActivityView;
        addCommentActivityModel=new AddCommentActivityModelImp();
    }

    @Override
    public void setCommentData(String newsid, String name, String email, String details) {
        addCommentActivityView.showProgress();
        addCommentActivityModel.getDataFromServer(newsid,name,email,details,this);
    }

    @Override
    public void onSuccess(DefaultDataModel result) {
        addCommentActivityView.hideProgress();
        addCommentActivityView.commentUploded(result.getMessage());

    }

    @Override
    public void onFailure(String alert) {
        addCommentActivityView.hideProgress();
        addCommentActivityView.showAlert(alert);
    }

    @Override
    public void emailError(String alert) {
        addCommentActivityView.hideProgress();
        addCommentActivityView.emailError(alert);
    }
}
