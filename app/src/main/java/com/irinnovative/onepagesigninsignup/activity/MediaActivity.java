package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irinnovative.onepagesigninsignup.R;

public class MediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
    }


    public void movies (View v){
        Intent moviesintent = new Intent(MediaActivity.this,MoviesActivity.class);
        startActivity(moviesintent);
    }



    public void audio (View v){
        Intent audiointent = new Intent(MediaActivity.this,BooksActivity.class);
        startActivity(audiointent);
    }

    public void video (View v){
        Intent videointent = new Intent(MediaActivity.this,VideoActivity.class);
        startActivity(videointent);
    }


}
