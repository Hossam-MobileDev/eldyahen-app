package com.elabda3.eldaya7een.NewsPackage;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import com.elabda3.eldaya7een.UrlPagePackage.UrlPageActivity;
import com.elabda3.eldaya7een.model.NewsAdsDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.viewpager.widget.PagerAdapter;


/**
 * Created by ebda3-mint on 10/10/17.
 */

public class NewsPagerAdapter extends PagerAdapter {

    Context context;
    List<NewsAdsDataModel> list;

    public NewsPagerAdapter(Context context, List<NewsAdsDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View view= LayoutInflater.from(context).inflate(R.layout.news_pager_ads,container,false);
        ImageView imageView=view.findViewById(R.id.adsImage);
        Glide.with(context).load(list.get(position).getFileurl()).into(imageView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, UrlPageActivity.class);
                intent.putExtra("url",list.get(position).getTargeturl());
                context.startActivity(intent);
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
