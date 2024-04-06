package com.elabda3.eldaya7een.VideoPackage;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.elabda3.eldaya7een.RoundedCornersTransform;
import com.elabda3.eldaya7een.VideoDetailsPackage.VideoDetailsActivity;
import com.elabda3.eldaya7een.model.VideoDataModel;
import com.hashtag.eldya7een.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by ebda3-mint on 10/9/17.
 */

public class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.MyHolder>{

    Context context;
    List<VideoDataModel> list;

    public VideoRecyclerAdapter(Context context, List<VideoDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.video_row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        Picasso.with(context).load(list.get(position).getPhoto()).transform(new RoundedCornersTransform(5,0)).into(holder.videoImage);
        holder.vedioTitle.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView videoImage;
        TextView vedioTitle;

        public MyHolder(View itemView) {
            super(itemView);
            
            vedioTitle=itemView.findViewById(R.id.videoTitle);
            videoImage=itemView.findViewById(R.id.videoImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Intent intent=new Intent(context, VideoDetailsActivity.class);
            intent.putExtra("title",list.get(getAdapterPosition()).getTitle());
            intent.putExtra("content",list.get(getAdapterPosition()).getDescription());
            intent.putExtra("url",list.get(getAdapterPosition()).getVideourl());
            context.startActivity(intent);

        }
    }
}
