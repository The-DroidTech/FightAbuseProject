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
        listMentors.add(new Mentor("Marita Rademeyer","Kinder Trauma Kliniek",R.drawable.marita));
        listMentors.add(new Mentor("Edith Kriel","Child Trauma Centre",R.drawable.edith_kriel));
        listMentors.add(new Mentor("Andrea Dondolo","Lead SA Hero",R.drawable.andrea_dondolo));
        listMentors.add(new Mentor("Maria Mabetoa","Department of Social Work Unisa",R.drawable.maria_mabetoa));
        listMentors.add(new Mentor("Winnie Lindi Morake" ,"Department of Social Work Unisa ",R.drawable.winniindi));
        listMentors.add(new Mentor("SURESHNIE RIDER","BLOW THE WHISTLE",R.drawable.sureshine_rider));
        listMentors.add(new Mentor("TAINE NEWPORT","The Foundation Clinic",R.drawable.taine_newport));
        listMentors.add(new Mentor("LEIGH-ANNE BRIERLEY","BLOW THE WHISTLE",R.drawable.leigh_anne));
        listMentors.add(new Mentor("Ms Tryphosa Senoamadi","Focus building",R.drawable.tryposa));
        listMentors.add(new Mentor("ENNIE PHUNGO","Cnr Lovedale & Plein Street",R.drawable.ennie));
        listMentors.add(new Mentor("RUTH KATZ","RUTH KATZ CONSULTING",R.drawable.ruth));
        listMentors.add(new Mentor(" Ayesha Malagas","Stars Wellness",R.drawable.ayesha));
        listMentors.add(new Mentor("Peter Guess","Peter Guess Therapist",R.drawable.peter_guess));








        lvMentors = (ListView) findViewById(R.id.lvMentor);
        MentorAdapter adapter = new MentorAdapter(this,listMentors);
        lvMentors.setAdapter(adapter);
    }
}
