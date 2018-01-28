package com.example.nysil.newsnow;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CustomRecycle extends RecyclerView.Adapter<CustomRecycle.DataViewHolder> {

    private ArrayList<News>  arrayList;
    private Context context;
    CustomRecycle( ArrayList<News> arrayList, Context context)
    {
        this.arrayList=arrayList;
        this.context=context;
    }
    @Override
    public CustomRecycle.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent,false);
        DataViewHolder dataViewHolder=new DataViewHolder(view);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomRecycle.DataViewHolder holder, int position) {

        News news= arrayList.get(position);


        String name =news.getHeading();
        String story=news.getStroy();
        String urlImage=news.getImageUrl();
       // Bitmap bm=news.getBitmap();


        //holder.imageView.setImageBitmap(bm);

        Picasso.with(context).load(urlImage).into(holder.imageView);

        holder.textView.setText( name);
        holder.textView2.setText(story);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class DataViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView, textView2;
        ImageView imageView;

        public DataViewHolder(View itemView) {
            super(itemView);

            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            textView=(TextView)itemView.findViewById(R.id.textView);
            textView2=(TextView)itemView.findViewById(R.id.textView2);

        }
    }
}
