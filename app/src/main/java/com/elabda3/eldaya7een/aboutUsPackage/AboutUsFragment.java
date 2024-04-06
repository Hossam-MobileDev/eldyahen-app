package com.elabda3.eldaya7een.aboutUsPackage;


import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.elabda3.eldaya7een.model.WebDataModel;
import com.hashtag.eldya7een.R;

import androidx.fragment.app.Fragment;


public class AboutUsFragment extends Fragment implements AboutUsView {

    TextView titleTextView;
    WebView webView;
    ProgressBar progressBar;
    AboutUsPresenter aboutUsPresenter;

    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        titleTextView=view.findViewById(R.id.toolbarTitle);
        titleTextView.setText("من نحن");
        webView=view.findViewById(R.id.webView);
        progressBar=view.findViewById(R.id.progress);


        aboutUsPresenter=new AboutUsPresenterImp(this);


        return view;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showAlert(String alert) {
        if(!TextUtils.isEmpty(alert)) {
            if(getActivity() != null)
            Toast.makeText(getActivity(), alert, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void loadDataToWebView(WebDataModel dataModel) {
        webView.loadData(dataModel.getContent(),"text/html ; charset=utf-8","UTF-8");
    }
}
