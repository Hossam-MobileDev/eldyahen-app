package com.elabda3.eldaya7een.CalenderPackage;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.elabda3.eldaya7een.model.CalenderDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by ebda3-mint on 10/8/17.
 */

public class CalenderRecyclerAdapter extends RecyclerView.Adapter<CalenderRecyclerAdapter.MyHolder>{

    Context context;
    List<CalenderDataModel> list;

    public CalenderRecyclerAdapter(Context context, List<CalenderDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.calender_row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.date.setText(" تم إضافة الحجز في "+list.get(position).getAr_date().getDay()
                + " " + list.get(position).getAr_date().getNamemonth() +" " +
                list.get(position).getAr_date().getYear());
        holder.desc.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView date,title,desc;

        public MyHolder(View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

//            Intent intent=new Intent(context, CalenderDetailsActivity.class);
//            intent.putExtra("title",list.get(getAdapterPosition()).getTitle());
//            intent.putExtra("content",list.get(getAdapterPosition()).getContent());
//            intent.putExtra("photo",list.get(getAdapterPosition()).getPhoto());
//            context.startActivity(intent);

        }
    }
}
