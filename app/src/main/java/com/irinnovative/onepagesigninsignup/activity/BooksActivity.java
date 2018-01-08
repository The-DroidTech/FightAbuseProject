package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irinnovative.onepagesigninsignup.R;

public class BooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
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

    public void power(View v) {
        Intent powerintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.life-with-confidence.com/support-files/power-of-frustration3.pdf"));
        startActivity(powerintent);
    }

    public void comfort(View v) {
        Intent comfortintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.life-with-confidence.com/support-files/comfort-zone.pdf"));
        startActivity(comfortintent);
    }

    public void happy(View v) {
        Intent happyintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.life-with-confidence.com/support-files/howtobehappyeveryday-lwc.pdf"));
        startActivity(happyintent);
    }

    public void secret(View v) {
        Intent secretintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.life-with-confidence.com/support-files/the_secret_to_winning_every_time_brandable045227.pdf"));
        startActivity(secretintent);
    }

    public void rich(View v) {
        Intent richintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.life-with-confidence.com/support-files/think-and-grow-rich.pdf"));
        startActivity(richintent);
    }

    public void curse(View v) {
        Intent richintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.destinedtowin.org/pdf/BREAKING%2520THE%2520CURSE%2520OF%2520POVERTY.pdf"));
        startActivity(richintent);
    }






}
