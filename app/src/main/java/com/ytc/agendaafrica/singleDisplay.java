package com.ytc.agendaafrica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class singleDisplay extends AppCompatActivity {
    ImageView detailImage;
    TextView detailView,detailTitleview,datetextview,authorTextView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_display);
        detailImage= (ImageView) findViewById(R.id.detailimage);
        detailView= (TextView) findViewById(R.id.detailText);
        detailTitleview= (TextView) findViewById(R.id.newstitle);
        datetextview= (TextView) findViewById(R.id.posttime);
        authorTextView= (TextView) findViewById(R.id.authorTextView);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
         if(bd != null)
        {
            String imgurl  = bd.getString("image");
            String detailtitle  = bd.getString("name");
            String detaildescription  = bd.getString("desc");
            String date  = bd.getString("time");
            String author  = bd.getString("author");
            String location  = bd.getString("location");

            populatedatausingid(imgurl,detailtitle,detaildescription,date,author,location);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("News");
        setSupportActionBar(toolbar);


//this line shows back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void populatedatausingid(String imgurl, String detailtitle, String detaildescription,String date ,String author ,String location) {


        Glide.with(this)
                .load(imgurl)
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .into(detailImage);
        detailView.setText(detailtitle);
        detailTitleview.setText(detaildescription);
        datetextview.setText(date);
        authorTextView.setText(author);


    }




}
