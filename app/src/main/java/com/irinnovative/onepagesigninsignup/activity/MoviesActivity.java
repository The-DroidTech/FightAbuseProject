package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irinnovative.onepagesigninsignup.R;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }


    public void cry(View v) {
        Intent cryintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_YqXwVM_frg&list=PLF24D723238B368F6"));
        startActivity(cryintent);
    }

    public void damage(View v) {
        Intent damageintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=lHGf-UUqnSg&index=3&list=PLF24D723238B368F6"));
        startActivity(damageintent);
    }

    public void be(View v) {
        Intent katherineintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=lHGf-UUqnSg&index=3&list=PLF24D723238B368F6"));
        startActivity(katherineintent);
    }

    public void broken(View v) {
        Intent brokenintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=guaG981MLoQ"));
        startActivity(brokenintent);
    }

    public void beautiful(View v) {
        Intent beautifulintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=bmUfJtsaqps"));
        startActivity(beautifulintent);
    }

    public void fight(View v) {
        Intent fightintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=xo1VInw-SKc"));
        startActivity(fightintent);
    }

    public void climb(View v) {
        Intent climbintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=NG2zyeVRcbs&list=PLCjDivseazNzzH6pla2VYAFCT1bwWh86j"));
        startActivity(climbintent);
    }

    public void here(View v) {
        Intent hereintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=i41qWJ6QjPI"));
        startActivity(hereintent);
    }

    public void wide(View v) {
        Intent wideintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dom7VlltBUc&list=PL5cPgAcnxc-crhIlMXhyXWCKa-k8F1JOl&index=5"));
        startActivity(wideintent);
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
