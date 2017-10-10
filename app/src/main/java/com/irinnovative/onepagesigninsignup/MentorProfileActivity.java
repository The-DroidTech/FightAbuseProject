package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.irinnovative.onepagesigninsignup.pojo.Mentor;

public class MentorProfileActivity extends AppCompatActivity {
    private TextView txtViewName,txtViewDescripion,txtViewWebsite,txtViewContacts,txtViewEmail;
    private ImageView imProfilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_profile);

        txtViewName = (TextView) findViewById(R.id.editText_mentor_name);
        txtViewDescripion = (TextView) findViewById(R.id.textView_mentor_description);
        txtViewContacts = (TextView) findViewById(R.id.textView_mentor_contact);
        txtViewEmail = (TextView) findViewById(R.id.textView_mentor_email);
        txtViewWebsite = (TextView) findViewById(R.id.textView_mentor_website);
        imProfilePic = (ImageView) findViewById(R.id.imageView_mentor_pic);

        Intent intent = getIntent();
        Mentor mentor = (Mentor) intent.getSerializableExtra("mentor");

        txtViewName.setText(mentor.getName());
        imProfilePic.setImageResource(mentor.getImage());
        txtViewDescripion.setText("");
        txtViewContacts.setText("");
        txtViewEmail.setText("");
        txtViewWebsite.setText("");
    }
}
