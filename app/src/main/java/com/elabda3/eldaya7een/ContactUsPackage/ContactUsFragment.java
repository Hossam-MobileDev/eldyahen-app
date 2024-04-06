package com.elabda3.eldaya7een.ContactUsPackage;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.elabda3.eldaya7een.UrlPagePackage.UrlPageActivity;
import com.hashtag.eldya7een.R;

import androidx.fragment.app.Fragment;


public class ContactUsFragment extends Fragment implements View.OnClickListener , ContactUsView {

    TextView title,phoneTextView1,phoneTextView2;

    EditText fullname,email,comment;
    Button send;
    ProgressBar progressBar;

    ImageView face,youtube,insta,twitter;




    ContactUSPresenterImp contactUSPresenterImp;

    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_contact_us, container, false);


        title=view.findViewById(R.id.toolbarTitle);
        title.setText("إتصل بنا");

        fullname=view.findViewById(R.id.fullname);
        email=view.findViewById(R.id.email);
        comment=view.findViewById(R.id.comment);

        progressBar=view.findViewById(R.id.progress);

        send=view.findViewById(R.id.send);
        send.setOnClickListener(this);


        face=view.findViewById(R.id.facebook);
        face.setOnClickListener(this);

        youtube=view.findViewById(R.id.youtube);
        youtube.setOnClickListener(this);

        twitter=view.findViewById(R.id.twitter);
        twitter.setOnClickListener(this);

        phoneTextView1=view.findViewById(R.id.phone1);
        phoneTextView2=view.findViewById(R.id.phone2);
        phoneTextView1.setOnClickListener(this);
        phoneTextView2.setOnClickListener(this);


        insta=view.findViewById(R.id.insta);
        insta.setOnClickListener(this);


        contactUSPresenterImp=new ContactUSPresenterImp(this);
        contactUSPresenterImp.setSocialUrl("http://aldaihani.org/aldaih/api.php?mod=socialmedia");


        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.send:
                contactUSPresenterImp.setContactData(fullname.getText().toString(), email.getText().toString(),
                        comment.getText().toString());
                break;
            case R.id.facebook:
                contactUSPresenterImp.openFaceUrl();
                break;
            case R.id.youtube:
                contactUSPresenterImp.openYoutubeUrl();
                break;
            case R.id.insta:
                contactUSPresenterImp.openInstaUrl();
                break;
            case R.id.twitter:
                contactUSPresenterImp.openTwitterUrl();
                break;
            case R.id.phone1:
                Intent intent=new Intent(Intent.ACTION_DIAL , Uri.parse("tel:"+phoneTextView1.getText().toString()));
                startActivity(intent);
                break;
            case R.id.phone2:
                Intent intent1=new Intent(Intent.ACTION_DIAL , Uri.parse("tel:"+phoneTextView2.getText().toString()));
                startActivity(intent1);
                break;

        }
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
        Toast.makeText(getActivity(), alert, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearViews() {
        fullname.setText("");
        email.setText("");
        comment.setText("");

    }

    @Override
    public void openFaceUrl(String url) {

         try {
                getActivity().getPackageManager().getPackageInfo("com.facebook.katana", 0);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"+url)));

            } catch (Exception e) {
                 Intent intent=new Intent(getActivity(), UrlPageActivity.class);
                 intent.putExtra("url",url);
                 startActivity(intent);
            }




    }

    @Override
    public void openYoutubeUrl(String url) {


        Intent intent=new Intent(getActivity(), UrlPageActivity.class);
        intent.putExtra("url","https://www.youtube.com/user/"+url);
        startActivity(intent);

    }

    @Override
    public void openInstaUrl(String url) {

        try {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            intent.setPackage("com.instagram.android");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {

            Intent intent=new Intent(getActivity(), UrlPageActivity.class);
            intent.putExtra("url","http://instagram.com/"+url);
            startActivity(intent);

        }



    }

    @Override
    public void openTwitterUrl(String url) {

        Intent intent=new Intent(getActivity(), UrlPageActivity.class);
        intent.putExtra("url","https://twitter.com/"+url);
        startActivity(intent);

    }

    @Override
    public void setPhoneNumber(String phone1, String phone2) {
        phoneTextView1.setText(phone1);
        phoneTextView2.setText(phone2);
    }
}
