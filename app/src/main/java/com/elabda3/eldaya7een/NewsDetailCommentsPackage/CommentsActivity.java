package com.elabda3.eldaya7een.NewsDetailCommentsPackage;

import android.content.Intent;

import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.elabda3.eldaya7een.AddCommentPackage.AddCommentActivity;

import com.elabda3.eldaya7een.model.CommentsDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommentsActivity extends AppCompatActivity implements View.OnClickListener ,DetailsCommentActivityView{

    RelativeLayout addCommentRelative;
    RecyclerView commentsRecycler;
    TextView toolbarTitle;

    ProgressBar progressBar;

    DetailsCommentPresenter addCommentPresenter;
    String newsid="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);


        toolbarTitle=findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("التعليقات");
        commentsRecycler=findViewById(R.id.commentsRecycler);
        commentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        addCommentRelative=findViewById(R.id.addcommentRelative);
        addCommentRelative.setOnClickListener(this);

        progressBar=findViewById(R.id.progress);

        if(getIntent().getExtras() != null){
            newsid=getIntent().getExtras().getString("newsid","");
        }

        addCommentPresenter=new DetailsCommentPresenterImp(this);





    }


    @Override
    protected void onResume() {
        super.onResume();
        addCommentPresenter.setNewsId(newsid);

    }

    @Override
    public void onClick(View view) {
        addCommentPresenter.openAddCommentActivity();
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
    public void showAlert(String alert) {

        if(!TextUtils.isEmpty(alert))
            Toast.makeText(this,alert, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initCommentsRecycler(List<CommentsDataModel> comments) {
        Log.v("start",comments.size()+">>>");

        DetailsCommentRecyclerAdapter addCommentRecyclerAdapter=new DetailsCommentRecyclerAdapter
                (this,comments);
        commentsRecycler.setAdapter(addCommentRecyclerAdapter);
        addCommentRecyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public void openAddCommentActivity() {
        Intent intent=new Intent(this, AddCommentActivity.class);
        intent.putExtra("newsid",newsid);
        startActivity(intent);
    }
}
