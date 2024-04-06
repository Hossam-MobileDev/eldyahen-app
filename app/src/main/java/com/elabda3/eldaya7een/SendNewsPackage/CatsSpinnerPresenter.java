package com.elabda3.eldaya7een.SendNewsPackage;

import com.darsh.multipleimageselect.models.Image;

import java.util.List;

/**
 * Created by ebda3-mint on 10/3/17.
 */

public interface CatsSpinnerPresenter {

    void sendNewsData(String catId, String name, String email, String title, String details, String mainImagePath);
    void setNewsImages(List<Image> images);
}
