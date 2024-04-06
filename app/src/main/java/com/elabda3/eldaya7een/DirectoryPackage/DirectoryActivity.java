package com.elabda3.eldaya7een.DirectoryPackage;

import android.content.Intent;

import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.elabda3.eldaya7een.AddDirectoryPackage.AddDirectoryDialogActivity;

import com.elabda3.eldaya7een.model.DirectoryDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DirectoryActivity extends AppCompatActivity implements DirectoryActivityView, View.OnClickListener{

    RecyclerView directoryRecycler;
    ProgressBar progressBar;
    DirectoryPresenter directoryPresenter;
    ImageView addDirectory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        directoryRecycler=findViewById(R.id.directoryRecycler);
        directoryRecycler.setLayoutManager(new LinearLayoutManager(this));

        progressBar=findViewById(R.id.progress);

        addDirectory=findViewById(R.id.addDirectory);
        addDirectory.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("ssssss","start");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("ssssss","resume");

        directoryPresenter = new DirectoryPresenterImp(this);

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
        if(!TextUtils.isEmpty(alert))
            Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initDirectoryRecycler(List<DirectoryDataModel> list) {

        DirectoryRecyclerAdapter directoryRecyclerAdapter=new DirectoryRecyclerAdapter(this,list);
        directoryRecycler.setAdapter(directoryRecyclerAdapter);
    }

    @Override
    public void openAddDirectory() {
        Intent intent=new Intent(this, AddDirectoryDialogActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        directoryPresenter.navigateToOpenAddDirecoryDialog();
    }
}
