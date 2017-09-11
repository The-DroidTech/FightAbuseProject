package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.irinnovative.onepagesigninsignup.IconTextTabsActivity;
import com.irinnovative.onepagesigninsignup.InstitutionActivity;
import com.irinnovative.onepagesigninsignup.MentorsActivity;
import com.irinnovative.onepagesigninsignup.R;

public class HomeActivity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       // getSupportActionBar().setTitle("HOME PAGE");
    }



    public void learn (View v){
        Intent intent = new Intent(HomeActivity.this,IconTextTabsActivity.class);
        startActivity(intent);
    }


    public void contacts(View v){
        Intent intent = new Intent(HomeActivity.this,ContactsActivity.class);
        startActivity(intent);
    }

    public void institution(View v){
        Intent intent = new Intent(HomeActivity.this,InstitutionActivity.class);
        startActivity(intent);
    }

    public void support(View v){
        Intent intent = new Intent(HomeActivity.this,SupportGroups.class);
        startActivity(intent);
    }

    public void sos(View v){
        count++;
        if(count == 1)
        {
            Toast.makeText(this,"Double tap to activate sos",Toast.LENGTH_SHORT).show();
        }

        if(count > 2)
        {
            Toast.makeText(this,"SOS Activated",Toast.LENGTH_SHORT).show();
            count = 0;
        }

        //Intent intent = new Intent(HomeActivity.this,.class);
       // startActivity(intent);
    }

    public void mentors(View v){
        Intent intent = new Intent(HomeActivity.this,MentorsActivity.class);
        startActivity(intent);
    }


    public void profile(View v){
        Intent intent = new Intent(HomeActivity.this,ProfileActivity.class);
        startActivity(intent);
    }

}
