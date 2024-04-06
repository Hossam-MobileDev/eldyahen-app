package com.elabda3.eldaya7een.ImageAlbumDetails;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.elabda3.eldaya7een.RoundedCornersTransform;
import com.elabda3.eldaya7een.model.ImageAlbumDetailsDataModel;
import com.hashtag.eldya7een.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by ebda3-mint on 10/10/17.
 */

public class AllImagesRecyclerAdapter extends RecyclerView.Adapter<AllImagesRecyclerAdapter.MyHolder> {

    Context context;
    List<ImageAlbumDetailsDataModel> list;
    ImageAlbumDetailsPresenterImp  imageAlbumDetailsPresenterImp;

    public AllImagesRecyclerAdapter(Context context, List<ImageAlbumDetailsDataModel> list , ImageAlbumDetailsPresenterImp imageAlbumDetailsPresenterImp) {
        this.context = context;
        this.list = list;
        this.imageAlbumDetailsPresenterImp=imageAlbumDetailsPresenterImp;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.image_row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        Picasso.with(context).load(list.get(position).getPhoto()).transform(new RoundedCornersTransform(10,0)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            imageAlbumDetailsPresenterImp.setCurrentViewPager(getAdapterPosition());
        }
    }
}
