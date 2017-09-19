package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class SocialMediaActivity extends AppCompatActivity implements OnMenuSelectedListener, OnMenuStatusChangeListener {
    private CircleMenu Social;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
        initView();
    }


    private void initView() {

        Social = (CircleMenu) findViewById(R.id.circle_menu);
        Social.setMainMenu(Color.parseColor("#00aa8d"), R.drawable.home, R.drawable.exist);
        Social.addSubMenu(Color.parseColor("#008975"), R.drawable.facebook);
        Social.addSubMenu(Color.parseColor("#008975"), R.drawable.twitter);
        Social.addSubMenu(Color.parseColor("#008975"), R.drawable.instagram);
        Social.addSubMenu(Color.parseColor("#008975"), R.drawable.website);
        Social.setOnMenuSelectedListener(this);
        Social.setOnMenuStatusChangeListener(this);
    }

    @Override
    public void onMenuSelected(int i) {
        switch (i){

            // Facebook
            case 0:
                Toast.makeText(this,"Facebook",Toast.LENGTH_SHORT).show();
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/CityOfTshwane/"));
                startActivity(facebookIntent);

                break;


            //twitter
            case 1:
                Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/CityTshwane?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"));
                startActivity(twitterIntent);
                break;

            //instagram
            case 3:
                Intent instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tshwane.gov.za/Pages/default.aspx"));
                startActivity(instagramIntent);
                break;




            //website
            case 2:
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://help.instagram.com/165828726894770"));
                startActivity(websiteIntent);
                break;




        }

    }





    @Override
    public void onMenuOpened() {

    }

    @Override
    public void onMenuClosed() {

    }
}
