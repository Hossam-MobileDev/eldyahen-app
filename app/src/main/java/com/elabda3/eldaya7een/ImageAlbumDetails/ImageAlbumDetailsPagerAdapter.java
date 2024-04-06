package com.elabda3.eldaya7een.ImageAlbumDetails;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.elabda3.eldaya7een.model.ImageAlbumDetailsDataModel;
import com.hashtag.eldya7een.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.viewpager.widget.PagerAdapter;


/**
 * Created by ebda3-mint on 10/9/17.
 */

public class ImageAlbumDetailsPagerAdapter extends PagerAdapter {

    Context context;
    List<ImageAlbumDetailsDataModel> list;
    boolean b=true;
    ImageAlbumDetailsPresenterImp imageAlbumDetailsPresenterImp;


    public ImageAlbumDetailsPagerAdapter(Context context, List<ImageAlbumDetailsDataModel> list,ImageAlbumDetailsPresenterImp imageAlbumDetailsPresenterImp) {
        this.context = context;
        this.list = list;
        this.imageAlbumDetailsPresenterImp=imageAlbumDetailsPresenterImp;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout)object ;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view=LayoutInflater.from(context).inflate(R.layout.image_album_details_row,container,false);

        final ImageView detailsImage=view.findViewById(R.id.detailsImage);
        TextView title=view.findViewById(R.id.title);
        TextView content=view.findViewById(R.id.content);

        Picasso.with(context).load(list.get(position).getPhoto()).into(detailsImage);
        title.setText(list.get(position).getTitle());
        content.setText(list.get(position).getDescription());
        imageAlbumDetailsPresenterImp.showImageRecycler();
        detailsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int oldH=(int)(200 *(context.getResources().getDisplayMetrics().density));

                if(b) {
                    ViewGroup.LayoutParams params = detailsImage.getLayoutParams();
                    params.height= ViewGroup.LayoutParams.WRAP_CONTENT;
                   // params.width=ViewGroup.LayoutParams.WRAP_CONTENT;
                    detailsImage.setLayoutParams(params);
                    imageAlbumDetailsPresenterImp.hideImageRecycler();
                    b=false;
                }else {
                    ViewGroup.LayoutParams params = detailsImage.getLayoutParams();
                    params.height= oldH;
                 //   params.width= ViewGroup.LayoutParams.MATCH_PARENT;
                    detailsImage.setLayoutParams(params);
                    imageAlbumDetailsPresenterImp.showImageRecycler();
                    b=true;
                }

            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);
    }
}
