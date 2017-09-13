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

    public void sallie(View v) {
        Intent sallieintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/kazs-story"));
        startActivity(sallieintent);
    }

    public void kazza(View v) {
        Intent kazzaintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/kazs-story"));
        startActivity(kazzaintent);
    }

    public void angel(View v) {
        Intent angelintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/kazs-story"));
        startActivity(angelintent);
    }

    public void lenna(View v) {
        Intent lennaintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/kazs-story"));
        startActivity(lennaintent);
    }

    public void tina(View v) {
        Intent tinaintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/kazs-story"));
        startActivity(tinaintent);
    }

    public void isobel(View v) {
        Intent isobelintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/kazs-story"));
        startActivity(isobelintent);
    }

    public void donna(View v) {
        Intent donnaintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/kazs-story"));
        startActivity(donnaintent);
    }







}






