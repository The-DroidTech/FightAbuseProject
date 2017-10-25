package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.irinnovative.onepagesigninsignup.R;

public class SosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("tel:0800567567"));
        startActivity(intent);

    }
}
