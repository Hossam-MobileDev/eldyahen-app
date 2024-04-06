package com.elabda3.eldaya7een.SendNewsPackage;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.darsh.multipleimageselect.activities.AlbumSelectActivity;
import com.darsh.multipleimageselect.helpers.Constants;
import com.darsh.multipleimageselect.models.Image;

import com.elabda3.eldaya7een.model.CatsDataModel;
import com.hashtag.eldya7een.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by ebda3-mint on 10/3/17.
 */

public class SendNews extends Fragment implements SendNewsView, View.OnClickListener,
        AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
    TextView toolbarTitle;
    ImageView mainImage,images;
    EditText titleEditText,detailsEditText,nameEditText,emailEditText;
    Spinner catsSpinner;
    ProgressBar progressBar;
    CatsSpinnerPresenter catsSpinnerPresenter;
    String mainImagePath;
    String catId;
    List<CatsDataModel> catsList;
    ArrayList<Image> imagesList=new ArrayList<>();
    RecyclerView recyclerImages;

    public SendNews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_send_news, container, false);

        toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);

        progressBar=view.findViewById(R.id.progress);


        toolbarTitle=view.findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("إضافة خبر");

        mainImage=view.findViewById(R.id.mainImage);
        mainImage.setOnClickListener(this);
        images=view.findViewById(R.id.images);
        images.setOnClickListener(this);


        titleEditText=view.findViewById(R.id.title);
        detailsEditText=view.findViewById(R.id.details);
        nameEditText=view.findViewById(R.id.fullname);
        emailEditText=view.findViewById(R.id.email);

        catsSpinner=view.findViewById(R.id.catsSpinner);
        catsSpinner.setOnItemSelectedListener(this);

        recyclerImages=view.findViewById(R.id.recyclerImages);
        recyclerImages.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        catsSpinnerPresenter=new CatsSpinnerPresenterImp(this);


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.send_news,menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            catsSpinnerPresenter.sendNewsData(catId, nameEditText.getText().toString(),emailEditText.getText()
                    .toString(),titleEditText.getText().toString(), detailsEditText.getText().toString()
                    , mainImagePath);

        return true;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePogress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showAlert(String alert) {
        if(getActivity() != null)
        Toast.makeText(getActivity(), alert, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void initSpinner(List<CatsDataModel> list) {
        catsList=list;
        if(getActivity() != null) {
            CatsSpinnerAdapter catsSpinnerAdapter = new CatsSpinnerAdapter(getActivity(), R.layout.cat_row, list);
            catsSpinner.setAdapter(catsSpinnerAdapter);
        }

    }

    @Override
    public void newsUploaded(String msg) {
        if (getActivity() != null)
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();

        titleEditText.setText("");
        detailsEditText.setText("");
        nameEditText.setText("");
        emailEditText.setText("");
        catsSpinner.setSelection(0);
        mainImagePath="";
        mainImage.setImageResource(R.drawable.main_image);
        imagesList=new ArrayList<>();
        catsSpinnerPresenter.setNewsImages(imagesList);
    }

    @Override
    public void initImageRecycler(List<Image> imageList) {
        ImagesRecyclerAdapter imagesRecyclerAdapter=new ImagesRecyclerAdapter(getActivity(),imageList);
        recyclerImages.setAdapter(imagesRecyclerAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.mainImage:

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

                    Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(i, 1);
                }else{

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                    }
                }

                break;

            case R.id.images:
                Intent intent = new Intent(getActivity(), AlbumSelectActivity.class);
                intent.putExtra(Constants.INTENT_EXTRA_LIMIT, 4);
                startActivityForResult(intent, Constants.REQUEST_CODE);
                break;


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 1 && grantResults != null && grantResults.length >0){
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 1);
            }else{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1 && resultCode == Activity.RESULT_OK && data != null){
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            mainImagePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bitmap= BitmapFactory.decodeFile(mainImagePath);
            int nh = (int) ( bitmap.getHeight() * (512.0 / bitmap.getWidth()) );
            Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 512, nh, true);
            mainImage.setImageBitmap(scaled);
        }

        if (requestCode == Constants.REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {

            imagesList = data.getParcelableArrayListExtra(Constants.INTENT_EXTRA_IMAGES);
            catsSpinnerPresenter.setNewsImages(imagesList);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        catId=catsList.get(i).getCatId();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
