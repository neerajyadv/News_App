package com.example.nysil.newsnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView topNews=(TextView)findViewById(R.id.Top_Stories);
        TextView politicsNews=(TextView)findViewById(R.id.Technology_News);
        TextView sportsNews=(TextView)findViewById(R.id.Sports_News);
        TextView entertainmentNews=(TextView)findViewById(R.id.Entertainment_News);
        TextView scienceNews=(TextView)findViewById(R.id.Science_News);

        topNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this, TopStoriesActivity.class );
                startActivity(intent);
            }
        });

        politicsNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,  TechnologyActivity.class );
                startActivity(intent);
            }
        });

        sportsNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SportsActivity.class );
                startActivity(intent);
            }
        });

        entertainmentNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, EntertainmentActivity.class );
                startActivity(intent);
            }
        });

        scienceNews.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ScienceActivity.class);
                startActivity(intent);
            }
        });


    }
}
