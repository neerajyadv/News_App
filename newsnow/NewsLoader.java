package com.example.nysil.newsnow;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;


public class NewsLoader extends AsyncTaskLoader<ArrayList<News>> {
    private String URL;

    public NewsLoader(Context context, String URL) {
        super(context);
        this.URL=URL;
    }

    @Override
     protected void onStartLoading()
    {
        super.onStartLoading();
        forceLoad();
    }
    @Override
    public ArrayList<News> loadInBackground() {
        ArrayList<News> arrayList= QueryNews.getData(URL);
        return arrayList;
    }
}
