package com.elabda3.eldaya7een.ImageAlbumPackage;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elabda3.eldaya7een.ImageAlbumDetails.ImageAlbumDetailsActivity;

import com.elabda3.eldaya7een.model.AlbumDatamodel;
import com.hashtag.eldya7een.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by ebda3-mint on 10/8/17.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyHolder>{

    Context context;
    List<AlbumDatamodel> list;

    public AlbumAdapter(Context context, List<AlbumDatamodel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  new MyHolder(LayoutInflater.from(context).inflate(R.layout.album_row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        try {

            if(list.get(position).getPhotolist().size() > 0)
            Picasso.with(context).load(list.get(position).getPhotolist().get(0)).into(holder.image1);

            if(list.get(position).getPhotolist().size() > 1)
            Picasso.with(context).load(list.get(position).getPhotolist().get(1)).into(holder.image2);

        }catch (Exception e){
            e.printStackTrace();
        }

        if(list.get(position).getTotalitems() > 0) {
            holder.num.setVisibility(View.VISIBLE);
            holder.num.setText("+" + list.get(position).getTotalitems());
        }else{
            holder.num.setVisibility(View.GONE);
        }

        holder.title.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title,num;
        ImageView image1,image2;


        public MyHolder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            num=itemView.findViewById(R.id.num);
            image1=itemView.findViewById(R.id.image1);
            image2=itemView.findViewById(R.id.image2);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            Intent intent=new Intent(context, ImageAlbumDetailsActivity.class);
            intent.putExtra("url",list.get(getAdapterPosition()).getApi_url());
            context.startActivity(intent);

        }
    }
}
