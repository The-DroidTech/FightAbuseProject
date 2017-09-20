package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class SocialMediaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

    }



    public void twitter (View v){
        Intent twitterintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/LikwiSmart"));
        startActivity(twitterintent);
    }
    public void facebook (View v){
        Intent facebookintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/SmartPartier"));
        startActivity(facebookintent);
    }
    public void web (View v){
        Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://likwi-smart.business.site"));
        startActivity(webintent);
    }

}
