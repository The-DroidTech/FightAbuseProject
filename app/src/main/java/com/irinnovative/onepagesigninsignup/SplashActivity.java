package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.irinnovative.onepagesigninsignup.activity.HomeActivity;
import com.irinnovative.onepagesigninsignup.activity.NavigationActivity;

public class SplashActivity extends AppCompatActivity {
    private RelativeLayout layout;
    private static int SPLASH_TIME_OUT = 4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        layout = (RelativeLayout) findViewById(R.id.splash_layout);
        layout.setBackgroundResource(R.drawable.splash);


        new Handler().postDelayed(new Runnable(){

            @Override
            public void run(){
                Intent homeIntent = new Intent(SplashActivity.this,NavigationActivity.class);
                startActivity(homeIntent);
                finish();
            }

        },SPLASH_TIME_OUT);
    }

}
