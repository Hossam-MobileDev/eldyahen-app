package com.elabda3.eldaya7een.NewsPackage;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elabda3.eldaya7een.NewsDetailsPackage.NewsDetailsActivity;

import com.elabda3.eldaya7een.RoundedCornersTransform;
import com.elabda3.eldaya7een.model.NewsDataModel;
import com.hashtag.eldya7een.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by ebda3-mint on 10/2/17.
 */

public class NewsActivityAdapter extends RecyclerView.Adapter<NewsActivityAdapter.MyHolder> {

    Context context;
    List<NewsDataModel> list;

    public NewsActivityAdapter(Context context, List<NewsDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.news_row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        Picasso.with(context).load(list.get(position).getPhoto()).
                transform(new RoundedCornersTransform(5, 0)).
                error(R.drawable.placeholder_small).into(holder.newsImage);
        holder.newsDate.setText(list.get(position).getDate());
        holder.newsTitle.setText(list.get(position).getTitle());
        holder.newsViews.setText(list.get(position).getViews() + "");
        holder.newsComments.setText(list.get(position).getNumberOfComments() + "");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView newsImage;
        TextView newsTitle,newsComments,newsViews,newsDate;

        public MyHolder(View itemView) {
            super(itemView);

            newsImage=itemView.findViewById(R.id.newsImage);
            newsTitle=itemView.findViewById(R.id.newsTitle);
            newsComments=itemView.findViewById(R.id.newsComments);
            newsViews=itemView.findViewById(R.id.newsViews);
            newsDate=itemView.findViewById(R.id.newsDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, NewsDetailsActivity.class);
                    intent.putExtra("url",list.get(getAdapterPosition()).getUrl());
                    intent.putExtra("nid",list.get(getAdapterPosition()).getNewsid());
                    context.startActivity(intent);
                }
            });

        }
    }

}
