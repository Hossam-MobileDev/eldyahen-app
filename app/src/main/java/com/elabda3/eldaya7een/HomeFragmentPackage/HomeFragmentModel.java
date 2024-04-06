package com.elabda3.eldaya7een.HomeFragmentPackage;

import com.elabda3.eldaya7een.model.AdsDataModel;
import com.elabda3.eldaya7een.model.HomeCatsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;
import com.elabda3.eldaya7een.model.SendTokenDataModel;

import java.util.List;



/**
 * Created by ebda3-mint on 10/2/17.
 */

public interface HomeFragmentModel {

    interface HomeFragmentModelListner{
        void onSuccess(List<HomeCatsDataModel> list);
        void onFailure(String alert);
        void onNewsAddsLoaded(List<AdsDataModel> list);


        void onNewsAdsHorizontalLoaded(List<NewsDataModel> list);
        void onNewsAdsHorizontalFail();
    }

    void  getCatsFromServer(HomeFragmentModelListner listner);
    void getNewsAdds(HomeFragmentModelListner listner);
    void getNewsAddsHorizontal(HomeFragmentModelListner listner);


}
