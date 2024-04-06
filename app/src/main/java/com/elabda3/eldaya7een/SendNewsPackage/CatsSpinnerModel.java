package com.elabda3.eldaya7een.SendNewsPackage;

import com.darsh.multipleimageselect.models.Image;
import com.elabda3.eldaya7een.model.CatsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/3/17.
 */

public interface CatsSpinnerModel {

    interface Listner{
        void onSuccess(List<CatsDataModel> list);
        void onFailure(String alert);

        void onNewsUploaded(String msg, String newsid);
        void onNewsImagesUploaded(String msg);
    }

    void getCatsFromServer(Listner listner);
    void uploadNews(String catId, String name, String email, String title, String details, String mainImagePath, Listner listner);
    void uploadNewsImages(String msg, String newsid, List<Image> list, Listner listner);

}
