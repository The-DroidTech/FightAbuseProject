package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irinnovative.onepagesigninsignup.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
    }

    public void loveHurt(View v) {
        Intent loveHurtintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=RyjBFUhxpss"));
        startActivity(loveHurtintent);
    }

    public void removed(View v) {
        Intent removedintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=lOeQUwdAjE0"));
        startActivity(removedintent);
    }

    public void who(View v) {
        Intent whointent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=uWi5iXnguTU"));
        startActivity(whointent);
    }

    public void leave(View v) {
        Intent leaveintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=SqcEpJ4YBO4"));
        startActivity(leaveintent);
    }

    public void rock(View v) {
        Intent rockintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=pJMM3BwE3EY"));
        startActivity(rockintent);
    }

    public void love(View v) {
        Intent loveintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=xImqF2-oaf8"));
        startActivity(loveintent);
    }

    public void inspired(View v) {
        Intent inspiredintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=xctvXwngaw0"));
        startActivity(inspiredintent);
    }

    public void dream(View v) {
        Intent dreamintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=C31rj-bZ7dA"));
        startActivity(dreamintent);
    }

    public void thatsIt(View v) {
        Intent thatsItintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dvrcv.org.au/stories/true-stories/stories-women/kazs-story"));
        startActivity(thatsItintent);
    }


}
