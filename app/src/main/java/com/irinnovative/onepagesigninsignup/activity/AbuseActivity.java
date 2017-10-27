package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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


       //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        txtTopic = (TextView) findViewById(R.id.txt_abuse_topic);
        txtDesc = (TextView) findViewById(R.id.txt_abuse_desc);
        imageView = (ImageView) findViewById(R.id.image_abuse);

        Intent intent = getIntent();
        Abuse abuse = (Abuse) intent.getSerializableExtra("content");
        toolbar.setTitle(abuse.getTopic());

        txtTopic.setText(abuse.getTopic());
        txtDesc.setText(abuse.getDesc());
        imageView.setImageResource(abuse.getImg());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {

            onBackPressed();
        }


        return super.onOptionsItemSelected(item);
    }
}
