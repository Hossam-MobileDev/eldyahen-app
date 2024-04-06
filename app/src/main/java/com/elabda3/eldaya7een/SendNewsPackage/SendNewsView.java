package com.elabda3.eldaya7een.SendNewsPackage;

import com.darsh.multipleimageselect.models.Image;
import com.elabda3.eldaya7een.model.CatsDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/3/17.
 */

public interface SendNewsView {

    void showProgress();
    void hidePogress();
    void showAlert(String alert);
    void initSpinner(List<CatsDataModel> list);
    void newsUploaded(String msg);
    void initImageRecycler(List<Image> imageList);

}
