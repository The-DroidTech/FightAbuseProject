package com.irinnovative.onepagesigninsignup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.irinnovative.onepagesigninsignup.adapter.MentorAdapter;
import com.irinnovative.onepagesigninsignup.pojo.Mentor;

import java.util.ArrayList;

public class MentorsActivity extends AppCompatActivity {
    private ArrayList<Mentor> listMentors;
    private ListView lvMentors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentors);

        listMentors = new ArrayList<Mentor>();
        listMentors.add(new Mentor("Marita Rademeyer"," clinical psychologist","Kinder Trauma Kliniek",R.drawable.marita));
        listMentors.add(new Mentor("Edith Kriel","social worker and play therapist","Child Trauma Centre",R.drawable.edith_kriel));
        listMentors.add(new Mentor("Mashilo Mnisi","chief executive of this men’s rights organisation","MOSHATE MEN'S RIGHTS ORGANISATION",R.drawable.moshate));
        listMentors.add(new Mentor("Katlego More","Cape Town","Western Cape Foundation",R.drawable.katlego));
        listMentors.add(new Mentor("Linda Smith","Pretoria","Africa's daughters",R.drawable.linda));
        listMentors.add(new Mentor("Belinda Chai","PE","Africa's daughters",R.drawable.belinda));




        lvMentors = (ListView) findViewById(R.id.lvMentor);
        MentorAdapter adapter = new MentorAdapter(this,listMentors);
        lvMentors.setAdapter(adapter);
    }
}
