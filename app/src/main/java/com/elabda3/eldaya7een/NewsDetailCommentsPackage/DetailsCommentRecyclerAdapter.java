package com.elabda3.eldaya7een.NewsDetailCommentsPackage;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elabda3.eldaya7een.EncodeAndDecodeString.EncodeDecodeString;

import com.elabda3.eldaya7een.model.CommentsDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by ebda3-mint on 10/3/17.
 */

public class DetailsCommentRecyclerAdapter extends RecyclerView.Adapter<DetailsCommentRecyclerAdapter.MyHolder>{

    Context context;
    List<CommentsDataModel> list;

    public DetailsCommentRecyclerAdapter(Context context, List<CommentsDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.comment_row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.commentDate.setText(list.get(position).getStringtime());
        holder.commentDetails.setText(EncodeDecodeString.decodeString(list.get(position).getContent()));
        holder.commentTitle.setText(list.get(position).getUsername());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView commentTitle,commentDate,commentDetails;

        public MyHolder(View itemView) {
            super(itemView);
            commentTitle=itemView.findViewById(R.id.commentTitle);
            commentDate=itemView.findViewById(R.id.date);
            commentDetails=itemView.findViewById(R.id.commentDetails);

        }
    }
}
