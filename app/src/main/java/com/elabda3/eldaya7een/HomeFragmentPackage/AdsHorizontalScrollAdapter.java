package com.elabda3.eldaya7een.HomeFragmentPackage;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elabda3.eldaya7een.NewsDetailsPackage.NewsDetailsActivity;

import com.elabda3.eldaya7een.model.NewsDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by ebda3-mint on 10/29/17.
 */

public class AdsHorizontalScrollAdapter extends RecyclerView.Adapter<AdsHorizontalScrollAdapter.MyHolder> {

    Context context;
    List<NewsDataModel> list;

    public AdsHorizontalScrollAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.ads_horizontal_row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.adsText.setText(list.get((position % list.size())).getDescription());

    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView adsText;

        public MyHolder(View itemView) {
            super(itemView);
            adsText=itemView.findViewById(R.id.ads_text);
            adsText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, NewsDetailsActivity.class);
                    intent.putExtra("url",list.get(getAdapterPosition()%list.size()).getUrl());
                    intent.putExtra("nid",list.get(getAdapterPosition()%list.size()).getNewsid());
                    context.startActivity(intent);
                }
            });
        }
    }
}
