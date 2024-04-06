package com.elabda3.eldaya7een.SendNewsPackage;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.darsh.multipleimageselect.models.Image;

import com.hashtag.eldya7een.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by ebda3-mint on 10/4/17.
 */

public class ImagesRecyclerAdapter  extends RecyclerView.Adapter<ImagesRecyclerAdapter.MyHolder>{

    Context context;
    List<Image> list;

    public ImagesRecyclerAdapter(Context context, List<Image> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.image_row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Log.v("iniiii","here"+list.get(position).path);
        File file=new File(list.get(position).path);
        Picasso.with(context).load(file).fit().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView image;
        public MyHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
        }
    }
}
