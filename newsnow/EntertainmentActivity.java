package com.example.nysil.newsnow;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class EntertainmentActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<News>> {

    private CustomRecycle customRecycle;
    private RecyclerView recyclerView;
    private String URL_GET_DATA="https://newsapi.org/v2/everything?sources=entertainment-weekly&apiKey=905fbda7f3944db1b3e9acaac4b51018";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


         recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
//
//         customRecycle=new CustomRecycle(data, getApplicationContext());
//
//        recyclerView.setAdapter(customRecycle);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        getLoaderManager().initLoader(1, null, this);

    }

    @Override
    public Loader<ArrayList<News>> onCreateLoader(int i, Bundle bundle) {
        NewsLoader newsLoader=new NewsLoader(this, URL_GET_DATA);
        return newsLoader;
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<News>> loader, ArrayList<News> newsArrayList) {
        customRecycle=new CustomRecycle(newsArrayList, getApplicationContext());
        recyclerView.setAdapter(customRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onLoaderReset(Loader<ArrayList<News>> loader) {
        loader.reset();
    }
}
