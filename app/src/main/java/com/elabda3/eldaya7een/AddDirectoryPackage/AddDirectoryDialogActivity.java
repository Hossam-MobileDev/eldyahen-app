package com.elabda3.eldaya7een.AddDirectoryPackage;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.hashtag.eldya7een.R;

import androidx.appcompat.app.AppCompatActivity;

public class AddDirectoryDialogActivity extends AppCompatActivity implements View.OnClickListener  , AddDirectoryDialogView{


    EditText fullnameEditText,phoneEditText,cityEditText;
    Button sendButton;
    ProgressBar progressBar;

    AddDirectoryPresenterImp addDirectoryPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add_directory_dialog);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_directory_dialog);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.BOTTOM);

        fullnameEditText=findViewById(R.id.fullName);
        phoneEditText=findViewById(R.id.phone);
        cityEditText=findViewById(R.id.city);

        sendButton=findViewById(R.id.send);
        sendButton.setOnClickListener(this);

        progressBar=findViewById(R.id.progress);

        addDirectoryPresenter=new AddDirectoryPresenterImp(this);



    }

    @Override
    public void onClick(View view) {
        String fullNameString=fullnameEditText.getText().toString();
        String phoneString=phoneEditText.getText().toString();
        String cityString=cityEditText.getText().toString();

        addDirectoryPresenter.sendDirectotyData(fullNameString,cityString,phoneString);

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
    public void closeDialog() {
        finish();
    }

}
