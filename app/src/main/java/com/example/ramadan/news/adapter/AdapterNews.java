package com.example.ramadan.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ramadan.news.Detalis;
import com.example.ramadan.news.MainActivity;
import com.example.ramadan.news.R;
import com.example.ramadan.news.dataProcess.DataEncrpt;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ramadan on 4/2/2017.
 */
public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> implements View.OnClickListener{

ArrayList<DataEncrpt> list;
    MainActivity mainActivity;
    Context context;
    DataEncrpt dataEncrpt=new DataEncrpt();
    public AdapterNews(ArrayList<DataEncrpt>mylist,Context context,MainActivity mainActivity)
    {
        this.list=mylist;
        this.context=context;
        this.mainActivity=mainActivity;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.allitems,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        dataEncrpt=list.get(position);
        holder.cardView.setTag(position);

        holder.textTitle.setText(dataEncrpt.getTitle());
        holder.textDesc.setText(dataEncrpt.getDesc());
        Picasso.with(context).load(dataEncrpt.getImage()).into(holder.imageNews);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    CardView cardView;
    ImageView imageNews;
    TextView textTitle;
    TextView textDesc;

    public ViewHolder(View layout) {
        super(layout);

        cardView = (CardView) layout.findViewById(R.id.list_row_container);
        imageNews = (ImageView) layout.findViewById(R.id.news_image);
        textTitle = (TextView) layout.findViewById(R.id.title_news);
        textDesc = (TextView) layout.findViewById(R.id.desc_news);
        cardView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();

        dataEncrpt = list.get(position);

        Intent intent = new Intent(mainActivity, Detalis.class);

        intent.putExtra("title", dataEncrpt.getTitle());
        intent.putExtra("desc", dataEncrpt.getDesc());
        intent.putExtra("image", dataEncrpt.getImage());

        mainActivity.startActivity(intent);
    }
}
}
