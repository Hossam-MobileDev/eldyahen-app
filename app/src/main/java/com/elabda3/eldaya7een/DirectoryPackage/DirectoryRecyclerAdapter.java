package com.elabda3.eldaya7een.DirectoryPackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.elabda3.eldaya7een.model.DirectoryDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by ebda3-mint on 10/4/17.
 */

public class DirectoryRecyclerAdapter extends RecyclerView.Adapter<DirectoryRecyclerAdapter.MyHolder>{

    Context context;
    List<DirectoryDataModel> list;

    public DirectoryRecyclerAdapter(Context context, List<DirectoryDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.directory_row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.phone.setText(list.get(position).getPhone());
        holder.city.setText(list.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name,city,phone;

        public MyHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            city=itemView.findViewById(R.id.city);
            phone=itemView.findViewById(R.id.phone);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:" + list.get(getAdapterPosition()).getPhone()));
            context.startActivity(dialIntent);

        }
    }
}
