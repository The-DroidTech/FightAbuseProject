package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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

        //public Mentor(String name, String intitution, String description, String contacts,String email, String website, int image

        listMentors = new ArrayList<Mentor>();

        listMentors.add(new Mentor("Marita Rademeyer", "Kinder Trauma Kliniek","Marita has been practicing as a clinical psychologist for over twenty years, specializing in helping children and families deal with trauma and abuse. Marita has authored training materials and academic publications and consults to government departments and NGO’s. She has a special interest in working alongside children who come into conflict with the law. Marita and her husband are blessed with three inspiring children and six complicated cats.","012 998 1364","http://www.childtraumatraining.co.za","training@childtrauma.co.za", R.drawable.marita));

        listMentors.add(new Mentor("Edith Kriel", "Child Trauma Centre","Edith received the dean’s award for best student in social work. She developed the Teddy Bear Clinic for Abused Children to a multi-level service (1994-2000), initiated the Child Witness Project for RAPCAN (2001-2004), and developed the Healing Project for sexually abused children in co-operation with RAPCAN. Edith is the founding member of the Child Trauma Centre in Cape Town and Jelly Beanz Inc. She co-authored the “Voices of Hope – Healing stories for Africa’s children”, is requested to present regularly at national conferences and training for child protection and mental health professionals, as well as presenting a paper at the International Society for the Prevention of Child Abuse and Neglect conference 2012, and regularly being quoted in national media regarding child abuse issues. She regularly consults to various disciplines and organisations regarding child rights issues, and provides supervision to social workers and therapists. Outside of her therapeutic talents her strengths include her ability to influence and inspire others, to see the best in others and her sense of fun even while dealing with serious matters.","021 5569556","http://www.childtraumatraining.co.za","edith@childtraumacentre.co.za", R.drawable.edith_kriel));

        listMentors.add(new Mentor("Andrea Dondolo", "Lead SA Hero","Andrea Dondolo is a South African actress and activist.Andrea Dondolo stood up for women on Table Mountain in Cape Town South Africa as part of One Billion rising, to call for an end to violence against women and girls. She is rising up and using every chance she can get to encourage debate, speaking up against this atrocity. She is on an awareness campaign about how we can make a difference by not being spectators but being activists for change.","011 712 8420","http://www.ccifsa.org.za"," info@ccifsa.org.za", R.drawable.andrea_dondolo));

        listMentors.add(new Mentor("Maria Mabetoa", "Department of Social Work Unisa","Dr Maria Mabetoa is currently a senior lecturer in the Department of Social Work at Unisa. Her employment history started in Winterveldt and Hammanskraal, in 1976 and 1977 respectively, as a newly qualified social worker. After she took a five-year break to improve her qualifications in England, she worked as a senior lecturer in social work at the North-West University for 12 years.\n" +
                "\n" +
                "She joined the Department of Social Development (DSD) in 1997 as a Director for Social Integration. Her main focus areas were services to children, families, and youth. In 2002 she became the first manager for the HIV and AIDS Directorate in DSD and in 2005 she became Chief Director for Services to Children, Social Crime Prevention and VEP. Mabetoa was promoted to the position of Deputy Director General for Welfare Services in the same Department from 2008 to 2012.","012 356 8400","humatm@unisa.ac.za","https://www.sacssp.co.za/Contact", R.drawable.maria_mabetoa));
        listMentors.add(new Mentor("Winnie Lindi Morake", "Department of Social Work Unisa ","Winnie Lindi Morake holds a Master’s Degree in Social Science and BA Social Science (Social Work) from the University of South Africa. She has been appointed as a lecturer at Department of Social Work in the College of Human Sciences at Unisa since September 2014 to date. Prior to being a lecturer at Unisa, Winnie was employed in the following sectors: Social Development, Water, Non-Governmental (child and disability), and Consulting.\n" +
                "\n" +
                "Morake worked for the Department of Social Development as a social worker and senior social worker for seven years, for the Department of Water Affairs as a Development Expert and Chief Development Expert for four years, for Tshwane Child Welfare as a Manager for a year, for the Association for Autism as a Development Officer for two years, and as an Independent Consultant (Water sector, Seta sector, mining sector) for more than five years.","012 429 4917","morakmwl@unisa.ac.za","http://www.unisa.ac.za", R.drawable.winniindi));

        listMentors.add(new Mentor("SURESHNIE RIDER", "BLOW THE WHISTLE","5fm’s Sureshnie Rider, hosts the 5fm Top40 and is a News Reader on the National Radio station. Bubbly, Passionate, Positive and Energetic best describes Sush, as she is affectionately known On and Off air. She is a firm believer in the philosophy of ‘What the eyes can see the hands can do’. She is a Radio Personality, Dj/MC/Voiceover artist/Motivational Speaker and Community Builder.Blow the Whistle is literally that, it’s a campaign that promotes the purchase of a whistle to use as a defence mechanism. It’s a project that I conceptualised and co-founded with Legacy Lifestyle. We created actual whistles that citizens could keep around their necks, and use if they ever found themselves in a threatening position. A whistle can help you if you ever feel you don’t have a voice.","011 483 0940 ","info@owens.co.za","http://www.owens.co.za", R.drawable.sureshine_rider));

        listMentors.add(new Mentor("TAINE NEWPORT", "The Foundation Clinic","My name is Taine Newport; I am an addiction counsellor at Sharp Treatment Centre. I am currently studying my BSW (Bachelors in Social Work). I have worked in the field of addiction for 3 years now.\n" +
                "\n" +
                "In my experience, addiction is a coping mechanism and a survival skill. Many people in addiction use drugs to cope or fulfil a need initially but the addiction takes over and the substance or behaviour begins to have the opposite effect. Although the addiction essentially destroys one’s life, the initial purpose is to cope with life.","011 728 9200 ","https://www.thefoundationclinic.co.za","info@thefoundationclinic.co.za", R.drawable.taine_newport));

        listMentors.add(new Mentor("LEIGH-ANNE BRIERLEY", "The Foundation Clinic","Leigh-Anne Brierley is a certified Recovery and Life Coach. She is an internal and external Recovery Coach at The Foundation Clinic, working primarily in the area of substance abuse and recovery coaching in the clinic’s in- and outpatient programmes, as well as doing individual recovery coaching at the clinic.\n" +
                "\n" +
                "She facilitates the clinic’s outpatient, Recovery Wellness Programme and is also responsible for Wellness and Recovery Training and Coaching in the corporate market, as well as being a Recovery Coach Trainer through The Ubuntu Academy of Coaching & Training (U-ACT)."," 082 442 5710","http://www.recoverycoachingsa.com","leighanne@recoverycoachingsa.com", R.drawable.leigh_anne));

        listMentors.add(new Mentor("Ms Tryphosa Senoamadi", "Focus building","hold a Degree in Social work, Hounours in Psychology, Certificate in Employee Assistance programme, Certificate in Project management, Certificate in facilitation, Certificate in mentoring and certificate in Higher certificate in Management, counselling. I am self motivated, hard worker, goal oriented and a go getter. I possess leadership skills achieved through training offered through Foundation for Professional Development Scholarship for the course titled Higher Certificate in Management. I work well with diverse individuals across all levels. I am pro active and creative , eager to learn new things and also good at implementing good strategies that takes Employee Health and Wellness to higher level.","071 376 8330","http://www.medpages.co.za", "info@findhelp.co.za",R.drawable.tryposa));

        listMentors.add(new Mentor("ENNIE PHUNGO", "Cnr Lovedale & Plein Street","Specialising in: Addiction, child sexual abuse, chronic medical conditions, family difficulties, life changes, loss/grief, organisational development, relationships, self development, sexuality and gender, and trauma.","082 855 4395","http://www.medpages.co.za","mokete79@yahoo.com ", R.drawable.ennie));

        listMentors.add(new Mentor("RUTH KATZ", "RUTH KATZ CONSULTING","I've been an independent social work practitioner for 26 years. \n" +
                "\n" +
                "My work consists mainly of self-help groups for sufferers of Bipolar Mood Disorder, and training workshops for other mental health professionals on the subject: 'Adult Children of Alcoholics'.\n" +
                "\n" +
                "I've also recently started creating social media pages for my peers.\n" +
                "\n" +
                "Other Services:\n" +
                "\n" +
                "Anger Management\n" +
                "Career & Life Coaching\n" +
                "Supervision & Consultation to Colleagues & Students Computer Training For Seniors\n" +
                "\n" +
                "My work is based on an eclectic mix of theories, particularly, Gestalt, NLP and Positive Psychology \n","011 485 0800","www.recomed.co.za","ruthkatzsegercrantz@gmail.com", R.drawable.ruth));

        listMentors.add(new Mentor(" Ayesha Malagas", "Stars Wellness","SUPERVISION & MENTORSHIP: I have extensive experience in both supervision and mentoring of professional teams.\n" +
                "\n" +
                "MANAGEMENT: I have management experience and was responsible for managing service level agreements for a variety of companies in various sectors.\n" +
                "\n" +
                "REGISTERED SOCIAL WORKER: I have worked in both public and private sectors as well as NGO's over my 19 years in the field. I specialised in woman's issues; employee wellness and group work."," 083 730 4556","http://www.starswellness.co.za","  ayesha@starswellness.co.za ", R.drawable.ayesha));

        listMentors.add(new Mentor("Peter Guess", "Peter Guess Therapist"," Launched Coaching The Coach Academy of Learning. Distance learning to train Life Coaches.\n" +
                "* Managing a Consulting, Coaching and Counselling practice\n" +
                "* Addictions Counsellor\n" +
                "* Social Work as a generalist then specialising in therapeutic work with people with addictions and their family systems\n" +
                "* Life Coach\n" +
                "* Online Business Builder\n" +
                "* Project Management\n" +
                "* Web Design and Webmaster.","072 092 3315","http://www.peterguess-therapist.com/","peterguess1@gmail.com ", R.drawable.peter_guess));



        lvMentors = (ListView) findViewById(R.id.lvMentor);
        MentorAdapter adapter = new MentorAdapter(this, listMentors);
        lvMentors.setAdapter(adapter);


        lvMentors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mentor mentor = listMentors.get(position);

                Intent intent = new Intent(MentorsActivity.this, MentorProfileActivity.class);
                intent.putExtra("mentor",mentor);
                startActivity(intent);
            }
        });
    }
}
