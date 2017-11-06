package com.irinnovative.onepagesigninsignup.activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.irinnovative.onepagesigninsignup.R;

public class About extends AppCompatActivity {
    private ImageView imHeader,imTony,imThabang,imLesedi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imHeader = (ImageView) findViewById(R.id.ImageView_about_header);
        imLesedi = (ImageView) findViewById(R.id.image_view_about1);
        imThabang = (ImageView) findViewById(R.id.image_view_about2);
        imTony = (ImageView) findViewById(R.id.image_view_about3);

        Glide.with(getApplicationContext()).load(R.drawable.logoheader).into(imHeader);
        Glide.with(getApplicationContext()).load(R.drawable.tj).into(imThabang);
        Glide.with(getApplicationContext()).load(R.drawable.l).into(imLesedi);
        Glide.with(getApplicationContext()).load(R.drawable.tt).into(imTony);
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
