package com.elabda3.eldaya7een.HomeFragmentPackage;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elabda3.eldaya7een.NewsDetailsPackage.NewsDetailsActivity;

import com.elabda3.eldaya7een.model.AdsDataModel;
import com.hashtag.eldya7een.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.viewpager.widget.PagerAdapter;


/**
 * Created by ebda3-mint on 10/4/17.
 */

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    List<AdsDataModel> list;

    public ViewPagerAdapter(Context context, List<AdsDataModel> list) {
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

        View view= LayoutInflater.from(context).inflate(R.layout.news_ads_row,container,false);
        ImageView imageView=view.findViewById(R.id.image);
        TextView title=view.findViewById(R.id.title);

        Picasso.with(context).load(list.get(position).getPhoto()).into(imageView);
        title.setText(list.get(position).getTitle());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, NewsDetailsActivity.class);
                intent.putExtra("url",list.get(position).getUrl());
                intent.putExtra("nid",list.get(position).getNewsid());
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
