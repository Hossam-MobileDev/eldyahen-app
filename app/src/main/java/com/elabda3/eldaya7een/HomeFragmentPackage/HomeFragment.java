package com.elabda3.eldaya7een.HomeFragmentPackage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.elabda3.eldaya7een.model.AdsDataModel;
import com.elabda3.eldaya7een.model.HomeCatsDataModel;
import com.elabda3.eldaya7een.model.NewsDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment implements HomeFragmentView{

    RecyclerView catRecycler,horizontalAds;
    TextView toolbarTitle;
    HomeFragmentPresenter homeFragmentPresenter;
    ProgressBar progressBar;
    ViewPager viewPager;
    CircleIndicator indicator;
    String token="";

    LinearLayoutManager linearLayoutManager;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        toolbarTitle=view.findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("الرئيسية");

        progressBar=view.findViewById(R.id.progress);

        horizontalAds=view.findViewById(R.id.horizontalRecycler);
        linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false){
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {

                if(getActivity() != null) {
                    LinearSmoothScroller smoothScroller = new LinearSmoothScroller(getActivity()) {

                        private static final float SPEED = 4000f;

                        @Override
                        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                            return SPEED / displayMetrics.densityDpi;
                        }

                    };

                    smoothScroller.setTargetPosition(position);
                    startSmoothScroll(smoothScroller);
                }

            }
        };
        horizontalAds.setLayoutManager(linearLayoutManager);


        initRecycler(view);



        initPager(view);





        homeFragmentPresenter=new HomeFragmentPresenterImp(this);
//      homeFragmentPresenter.setTokenFromPresenterToModel();
        homeFragmentPresenter.getNewsHorizontal();





        return view;
    }

    private void initRecycler(View view) {
        catRecycler = view.findViewById(R.id.catRecycler);
        catRecycler.setNestedScrollingEnabled(false);
        catRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    private void initPager(View view) {
        indicator= (CircleIndicator) view.findViewById(R.id.indicator);
        viewPager=view.findViewById(R.id.viewPager);
        viewPager.setClipToPadding(false);
        float density = getResources().getDisplayMetrics().density;
        int dp = (int)(50 / density);
        viewPager.setPageMargin(dp);

    }

    @Override
    public void initCatRecycler(List<HomeCatsDataModel> list) {
        HomeCatsAdapter homeCatsAdapter=new HomeCatsAdapter(getActivity(),list);
        catRecycler.setAdapter(homeCatsAdapter);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void initViewPager(List<AdsDataModel> list) {

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getActivity(),list);
        viewPager.setAdapter(viewPagerAdapter);
        indicator.setViewPager(viewPager);
        // viewPager.setPageTransformer(true, new DrawFromBackTransformer());



    }

    @Override
    public void initAdsHorizontal(final List<NewsDataModel> list) {
        AdsHorizontalScrollAdapter adapter=new AdsHorizontalScrollAdapter(getActivity(),list);
        horizontalAds.setAdapter(adapter);
        horizontalAds.scrollToPosition(Integer.MAX_VALUE -1);

        final Handler handler=new Handler();
        Runnable runnable=new Runnable() {

            @Override
            public void run() {

                if(linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0){
                    horizontalAds.scrollToPosition(list.size()-1);
                }

                horizontalAds.smoothScrollToPosition(0);
                handler.postDelayed(this,4000);



            }
        };

        handler.postDelayed(runnable,0);





    }

    @Override
    public void adsHorizontalFail() {
        horizontalAds.setVisibility(View.GONE);
    }


    @Override
    public void showAlert(String alert) {

        if(!TextUtils.isEmpty(alert))
            Toast.makeText(getActivity(), alert, Toast.LENGTH_SHORT).show();
    }


}
