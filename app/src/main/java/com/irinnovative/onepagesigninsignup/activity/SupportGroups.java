package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.irinnovative.onepagesigninsignup.EventsActivity;
import com.irinnovative.onepagesigninsignup.R;

public class SupportGroups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_groups);

        //this activates the chat section
        ImageView communities = (ImageView)findViewById(R.id.communities);

        communities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupportGroups.this, ChatActivity.class);
                startActivity(intent);
            }
        });


    }

    public void support (View v){

        startActivity(new Intent(SupportGroups.this,TestomoniesActivity.class));

    }

    public void events (View v){

        startActivity(new Intent(SupportGroups.this, EventsActivity.class));

    }


    public void media (View v){

        startActivity(new Intent(SupportGroups.this,MediaActivity.class));

    }
}
