package com.elabda3.eldaya7een.SendNewsPackage;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.elabda3.eldaya7een.model.CatsDataModel;
import com.hashtag.eldya7een.R;

import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * Created by ebda3-mint on 10/3/17.
 */

public class CatsSpinnerAdapter extends ArrayAdapter<List<CatsDataModel>> {

    Context context;
    int resource;
    List<CatsDataModel> list;
    TextView textView;

    public CatsSpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<CatsDataModel> list) {
        super(context,resource);
        this.context=context;
        this.resource=resource;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view= LayoutInflater.from(context).inflate(resource,parent,false);
        textView=view.findViewById(R.id.text);

        textView.setText(list.get(position).getTitle());

        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(resource,parent,false);
        textView=view.findViewById(R.id.text);

        textView.setText(list.get(position).getTitle());

        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
