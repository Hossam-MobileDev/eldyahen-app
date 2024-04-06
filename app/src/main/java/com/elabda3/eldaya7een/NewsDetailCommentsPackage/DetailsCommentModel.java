package com.elabda3.eldaya7een.NewsDetailCommentsPackage;

import com.elabda3.eldaya7een.model.CommentsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/3/17.
 */

public interface DetailsCommentModel {

    interface CommentListner{

        void onSuccess(List<CommentsDataModel> list);
        void onFailure(String alert);
        void checkNoDAta(String newsid);
        void onSuccessNoData(String noData);


    }


    void getDataFromServer(String newsid, CommentListner listner);
    void noComments(String newsid, CommentListner listner);


}
