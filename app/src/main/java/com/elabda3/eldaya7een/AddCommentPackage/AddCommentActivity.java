package com.elabda3.eldaya7een.AddCommentPackage;


import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.hashtag.eldya7een.R;

import androidx.appcompat.app.AppCompatActivity;

public class AddCommentActivity extends AppCompatActivity implements AddCommentActivityView, View.OnClickListener {

    ProgressBar progressBar;
    EditText fullname,email,details;
    Button send;
    AddCommentActivityPresenter addCommentActivityPresenter;
    String newsid="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.BOTTOM);

        progressBar=findViewById(R.id.progress);

        fullname=findViewById(R.id.fullName);
        fullname.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        fullname.setRawInputType(InputType.TYPE_CLASS_TEXT);

        email=findViewById(R.id.email);

        details=findViewById(R.id.comment);
        details.setRawInputType(InputType.TYPE_CLASS_TEXT);
        details.setImeOptions(EditorInfo.IME_ACTION_DONE);


        send=findViewById(R.id.send);
        send.setOnClickListener(this);

        if(getIntent().getExtras() != null){
            newsid=getIntent().getExtras().getString("newsid","");
        }


        addCommentActivityPresenter=new AddCommentActivityPresenterImp(this);


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
    public void emailError(String emailError) {

        Toast.makeText(this, emailError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlert(String alert) {
        if(!TextUtils.isEmpty(alert))
            Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void commentUploded(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    public void onClick(View view) {
        addCommentActivityPresenter.setCommentData(newsid,fullname.getText().toString(),
                email.getText().toString(),details.getText().toString());
    }
}
