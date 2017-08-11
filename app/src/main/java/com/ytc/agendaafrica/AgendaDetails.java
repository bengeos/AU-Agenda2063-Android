package com.ytc.agendaafrica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AgendaDetails extends AppCompatActivity {

    TextView aspirationTitle,agendadetailtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_details);
        aspirationTitle= (TextView) findViewById(R.id.aspirationTitle);
        agendadetailtext= (TextView) findViewById(R.id.agendadetailtext);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if(bd != null)
        {
            String id  = bd.getString("agendaid");
            String detailtitle  = bd.getString("agendaname");
            String detaildescription  = bd.getString("description");


            populatedatausingid(detailtitle,detaildescription,id);
        }

    }



    private void populatedatausingid(String detailtitle, String detaildescription, String id) {


        aspirationTitle.setText(detailtitle);
        agendadetailtext.setText(detaildescription);


    }


}
