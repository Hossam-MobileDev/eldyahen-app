package com.elabda3.eldaya7een.NewsDetailsPackage;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.elabda3.eldaya7een.NewsDetailCommentsPackage.CommentsActivity;
import com.elabda3.eldaya7een.NewsDetailsPackage.SqliteHelper.SqliteHelperDB;

import com.elabda3.eldaya7een.model.NewsDetailsDataModel;
import com.hashtag.eldya7een.R;
import com.robertsimoes.shareable.Shareable;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class NewsDetailsActivity extends AppCompatActivity implements View.OnClickListener,NewsDetailsView{

    TextView numcomments,numViews,date,newsTitle,toolbarTitle;
    WebView newsDetais;
    ImageView previous,next,share,favourit,comment,newsImage;
    ProgressBar progressBar;
    String url="",nextUrl="",previousUrl="",nid="";

    NewsDetailsPresenter newsDetailsPresenter;
    SqliteHelperDB sqliteHelperDB;

    boolean isFavourit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        numcomments=findViewById(R.id.newsComments);
        numViews=findViewById(R.id.newsViews);
        date=findViewById(R.id.newsDate);
        newsTitle=findViewById(R.id.newsTitle);
        toolbarTitle=findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("الخبر");
        newsDetais=findViewById(R.id.newsDetails);

        progressBar=findViewById(R.id.progress);


        previous=findViewById(R.id.left);
        previous.setOnClickListener(this);

        next=findViewById(R.id.right);
        next.setOnClickListener(this);

        share=findViewById(R.id.share);
        share.setOnClickListener(this);

        favourit=findViewById(R.id.fav);
        favourit.setOnClickListener(this);

        comment=findViewById(R.id.comment);
        comment.setOnClickListener(this);

        newsImage=findViewById(R.id.newsImage);

        if(getIntent().getExtras() != null){
            url=getIntent().getExtras().getString("url","");
            nid=getIntent().getExtras().getString("nid","");
        }


        newsDetailsPresenter=new NewsDetailsPresenterImp(this);
        newsDetailsPresenter.setUrl(url);

        sqliteHelperDB=new SqliteHelperDB(this);
        isFavourit=sqliteHelperDB.isFavourit(nid);


        Log.v("favvvvv",isFavourit+">>>>>>");

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.left:
                if(!previousUrl.equals("none") && !previousUrl.equals("")) {
                    String previousNid = previousUrl.split("nid=")[1];
                    nid = previousNid;

//                        Log.v("nnnnL",nid+">>>>"+previousUrl + "   "+url +"   "+nextUrl);

                    newsDetailsPresenter.setUrl(previousUrl);
                }


                break;

            case R.id.right:
                if(!nextUrl.equals("none") && !nextUrl.equals("") ) {
                    String nextNid = nextUrl.split("nid=")[1];
                    nid = nextNid;

//                    Log.v("nnnnR",nid+">>>>"+previousUrl+"    "+url+"     "+nextUrl);



                    newsDetailsPresenter.setUrl(nextUrl);
                }

                break;

            case R.id.comment:
                newsDetailsPresenter.getNewsId();
                break;
            case R.id.share:
                newsDetailsPresenter.getShare();
                break;
            case R.id.fav:

                if(sqliteHelperDB.isFavourit(nid)){
                    newsDetailsPresenter.removeFav();
                }else {
                    newsDetailsPresenter.getFav();
                }
                break;

        }

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
            Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initViewsWithData(NewsDetailsDataModel details) {

        if(details != null) {

            isFavourit=sqliteHelperDB.isFavourit(nid);
            if(isFavourit){
                favourit.setImageResource(R.drawable.favnews_selected);
                sqliteHelperDB.updateNewsNumViewandComments(nid,details.getViews()+"" ,
                        details.getNumberOfComments()+"");
            }else {
                favourit.setImageResource(R.drawable.favnews);
            }


            numcomments.setText(details.getNumberOfComments() + "");
            numViews.setText(details.getViews() + "");
            date.setText(details.getDate());
            newsTitle.setText(details.getTitle());
//            Log.v("newsDetails",details.getContent());
            newsDetais.loadData(details.getContent(), "text/html ; charset=utf-8", "utf-8");
            newsDetais.reload();
            Picasso.with(this).load(details.getPhoto()).into(newsImage);
            nextUrl = details.getNext();
            previousUrl = details.getPrev();
//
//            Log.v("nnnD",previousUrl+"   "+nextUrl);

        }

    }

    @Override
    public void openCommentsActivity(String newsId) {
        Intent intent=new Intent(this, CommentsActivity.class);
        intent.putExtra("newsid",newsId);
        startActivity(intent);
    }

    @Override
    public void initShare(String msg , String link) {
        Shareable shareAction = new Shareable.Builder(this)
                .message(msg)
                .url(link)
                .socialChannel(Shareable.Builder.FACEBOOK)
                .socialChannel(Shareable.Builder.EMAIL)
                .socialChannel(Shareable.Builder.GOOGLE_PLUS)
                .socialChannel(Shareable.Builder.LINKED_IN)
                .socialChannel(Shareable.Builder.TWITTER)
                .build();
        shareAction.share();
    }

    @Override
    public void setFavourit(NewsDetailsDataModel newsDetailsDataModel) {

        if(newsDetailsDataModel != null) {
            String title = newsDetailsDataModel.getTitle();
            String date = newsDetailsDataModel.getDate();
            String url = newsDetailsDataModel.getUrl();
            String photo = newsDetailsDataModel.getPhoto();
            String nid = newsDetailsDataModel.getNewsid();
            int comments = newsDetailsDataModel.getNumberOfComments();
            int views = newsDetailsDataModel.getViews();

            boolean inserted = sqliteHelperDB.insertNews(title, nid, date, url, photo, comments, views);

            if (inserted) {
                Toast.makeText(this, "تم الإضافة إلي المفضلة", Toast.LENGTH_SHORT).show();
                favourit.setImageResource(R.drawable.favnews_selected);

            } else {
                Toast.makeText(this, "لم يتم الإضافة إلي المفضلة", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void removeFavourit() {
        boolean inserted=sqliteHelperDB.removeNews(nid);

        if(inserted){
            Toast.makeText(this, "تم الحذف من المفضلة", Toast.LENGTH_SHORT).show();
            favourit.setImageResource(R.drawable.favnews);

        }else {
            Toast.makeText(this, "لم يتم الحذف من المفضلة", Toast.LENGTH_SHORT).show();
        }
    }
}
