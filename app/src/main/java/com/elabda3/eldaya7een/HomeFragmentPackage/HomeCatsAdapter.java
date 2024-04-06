package com.elabda3.eldaya7een.HomeFragmentPackage;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.elabda3.eldaya7een.AddDirectoryPackage.AddDirectoryDialogActivity;
import com.elabda3.eldaya7een.CalenderPackage.CalenderActivity;
import com.elabda3.eldaya7een.DirectoryPackage.DirectoryActivity;
import com.elabda3.eldaya7een.ImageAlbumPackage.ImageAlbumActivity;
import com.elabda3.eldaya7een.NewsPackage.NewsActivity;
import com.elabda3.eldaya7een.PagePackage.PageActivity;

import com.elabda3.eldaya7een.UrlPagePackage.UrlPageActivity;
import com.elabda3.eldaya7een.VideoPackage.VideoActivity;
import com.elabda3.eldaya7een.model.HomeCatsDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ebda3-mint on 10/2/17.
 */

public class HomeCatsAdapter extends RecyclerView.Adapter<HomeCatsAdapter.MyHolder> {

    Context context;
    List<HomeCatsDataModel> list;

    public HomeCatsAdapter(Context context, List<HomeCatsDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.cat_row_image,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        if(position % 2 == 0 ){
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.left_to_right);
            holder.itemView.startAnimation(animation);
            holder.catText.setText(list.get(position).getTitle());
        }else{

            Animation animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left);
            holder.itemView.startAnimation(animation);
            holder.catText.setText(list.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView catText;

        public MyHolder(View itemView) {
            super(itemView);
            catText=itemView.findViewById(R.id.catText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(list.get(getAdapterPosition()).getType().equals("category-news")){
                        Intent intent=new Intent(context, NewsActivity.class);
                        intent.putExtra("title",list.get(getAdapterPosition()).getTitle());
                        intent.putExtra("url",list.get(getAdapterPosition()).getUrl());
                        context.startActivity(intent);
                    }else if(list.get(getAdapterPosition()).getType().equals("dir")){
                        Intent intent=new Intent(context, DirectoryActivity.class);
                        context.startActivity(intent);
                    }else if(list.get(getAdapterPosition()).getType().equals("page")){
                        Intent intent=new Intent(context, PageActivity.class);
                        intent.putExtra("title",list.get(getAdapterPosition()).getTitle());
                        intent.putExtra("url",list.get(getAdapterPosition()).getUrl());
                        intent.putExtra("pageid",list.get(getAdapterPosition()).getUrl().split
                                ("pageid=")[1]);
                        context.startActivity(intent);
                    }else if(list.get(getAdapterPosition()).getType().equals("diradd")){
                        Intent intent=new Intent(context, AddDirectoryDialogActivity.class);
                        context.startActivity(intent);
                    }else if(list.get(getAdapterPosition()).getType().equals("url")){
                        Intent intent=new Intent(context, UrlPageActivity.class);
                        intent.putExtra("url",list.get(getAdapterPosition()).getUrl());
                        context.startActivity(intent);
                    }else if(list.get(getAdapterPosition()).getType().equals("calender")){
                        Intent intent=new Intent(context, CalenderActivity.class);
                        context.startActivity(intent);
                    }else if(list.get(getAdapterPosition()).getType().equals("photos")){
                        Intent intent=new Intent(context, ImageAlbumActivity.class);
                        intent.putExtra("title",list.get(getAdapterPosition()).getTitle());
                        context.startActivity(intent);
                    }else if(list.get(getAdapterPosition()).getType().equals("category-video")){
                        Intent intent=new Intent(context, VideoActivity.class);
                        intent.putExtra("title",list.get(getAdapterPosition()).getTitle());
                        intent.putExtra("url",list.get(getAdapterPosition()).getUrl());
                        context.startActivity(intent);
                    }


                }
            });
        }
    }
}
