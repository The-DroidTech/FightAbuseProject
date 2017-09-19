package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irinnovative.onepagesigninsignup.R;

public class TestomoniesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testomonies);
        getSupportActionBar().setTitle("TESTIMONIES");

    }

    public void ann(View v) {
        Intent annintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/anns-story"));
        startActivity(annintent);
    }

    public void jane(View v) {
        Intent janeintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/janes-story"));
        startActivity(janeintent);
    }

    public void katherine(View v) {
        Intent katherineintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/katherines-story"));
        startActivity(katherineintent);
    }

    public void jody(View v) {
        Intent jodyintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/jodys-story"));
        startActivity(jodyintent);
    }

    public void anna(View v) {
        Intent annaintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/annas-story"));
        startActivity(annaintent);
    }

    public void maria(View v) {
        Intent mariaintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/marias-story"));
        startActivity(mariaintent);
    }

    public void alex(View v) {
        Intent twitterintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/alexs-story"));
        startActivity(twitterintent);
    }

    public void kaz(View v) {
        Intent kazintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/kazs-story"));
        startActivity(kazintent);
    }

    public void jullie(View v) {
        Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/kazs-story"));
        startActivity(webintent);
    }

    public void andreas(View v) {
        Intent andreasintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lovegoodbadugly.com/andreas-story/"));
        startActivity(andreasintent);
    }

    public void samantha(View v) {
        Intent samanthaintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lovegoodbadugly.com/samanthas-story/"));
        startActivity(samanthaintent);
    }

    public void jacq(View v) {
        Intent jacqintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lovegoodbadugly.com/jacqs-story/"));
        startActivity(jacqintent);
    }

    public void dannielle(View v) {
        Intent danintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women-lesbian-relationships/dannielles-story"));
        startActivity(danintent);
    }

    public void david(View v) {
        Intent davidintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-men/davids-story"));
        startActivity(davidintent);
    }

    public void cyrus(View v) {
        Intent cyrusintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-men/cyrus-story"));
        startActivity(cyrusintent);
    }

    public void jade(View v) {
        Intent jadeintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women-lesbian-relationships/jades-story"));
        startActivity(jadeintent);
    }







}






