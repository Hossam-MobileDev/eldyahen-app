package com.elabda3.eldaya7een.AddCommentPackage;

/**
 * Created by ebda3-mint on 10/3/17.
 */

public interface AddCommentActivityView {

    void showProgress();
    void hideProgress();
    void emailError(String emailError);
    void showAlert(String alert);
    void commentUploded(String msg);
}
