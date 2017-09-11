package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Abuse;

public class AbuseActivity extends AppCompatActivity {
    private TextView txtTopic;
    private TextView txtDesc;
    private Toolbar toolbar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abuse);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTopic = (TextView) findViewById(R.id.txt_abuse_topic);
        txtDesc = (TextView) findViewById(R.id.txt_abuse_desc);
        imageView = (ImageView) findViewById(R.id.image_abuse);

        Intent intent = getIntent();
        Abuse abuse= (Abuse) intent.getSerializableExtra("content");
        toolbar.setTitle(abuse.getTopic());

        txtTopic.setText(abuse.getTopic());
        txtDesc.setText(abuse.getDesc());
        imageView.setImageResource(abuse.getImg());

    }
}
