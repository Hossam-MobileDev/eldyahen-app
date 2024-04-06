package com.elabda3.eldaya7een.FavouritFragmentPackage;


import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.elabda3.eldaya7een.NewsPackage.NewsActivityAdapter;

import com.elabda3.eldaya7een.model.NewsDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class FavouritFragment extends Fragment implements FavouritFragmentView {

    TextView title;
    RecyclerView favRecycler;
    ProgressBar progressBar;

    FavouritFragmentPresenterImp favouritFragmentPresenterImp;


    public FavouritFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_favourit, container, false);

        title=view.findViewById(R.id.toolbarTitle);
        if(getArguments() != null)
        title.setText(getArguments().getString("title",""));

        progressBar=view.findViewById(R.id.progress);

        favRecycler=view.findViewById(R.id.favRecycler);
        favRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        favouritFragmentPresenterImp=new FavouritFragmentPresenterImp(this);
        favouritFragmentPresenterImp.getFavourits(getActivity());



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        favouritFragmentPresenterImp.getFavourits(getActivity());


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
    public void initRecycler(List<NewsDataModel> list) {

        //use adapter of news

        NewsActivityAdapter adapter=new NewsActivityAdapter(getActivity(),list);
        favRecycler.setAdapter(adapter);

    }

    @Override
    public void showAlert(String msg) {

        if(!TextUtils.isEmpty(msg))
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
