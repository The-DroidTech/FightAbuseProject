package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.irinnovative.onepagesigninsignup.adapter.MentorsDataAdapter;
import com.irinnovative.onepagesigninsignup.pojo.Mentor;
import com.irinnovative.onepagesigninsignup.pojo.RecyclerItemClickListener;

import java.util.ArrayList;

public class MentorsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentors);

        //Method to populate items on the list(Recycler View)
        initViews();

        /*
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
        */
    }

    private void initViews()
    {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        final ArrayList<Mentor> listMentors;

        listMentors = new ArrayList<Mentor>();
        listMentors.add(new Mentor("Marita Rademeyer", "Kinder Trauma Kliniek", R.drawable.marita));
        listMentors.add(new Mentor("Edith Kriel", "Child Trauma Centre", R.drawable.edith_kriel));
        listMentors.add(new Mentor("Andrea Dondolo", "Lead SA Hero", R.drawable.andrea_dondolo));
        listMentors.add(new Mentor("Maria Mabetoa", "Department of Social Work Unisa", R.drawable.maria_mabetoa));
        listMentors.add(new Mentor("Winnie Lindi Morake", "Department of Social Work Unisa ", R.drawable.winniindi));
        listMentors.add(new Mentor("Sureshine Rider", "Blow The Whistle", R.drawable.sureshine_rider));
        listMentors.add(new Mentor("Taine Newport", "The Foundation Clinic", R.drawable.taine_newport));
        listMentors.add(new Mentor("Leigh-Anne Brierley", "Blow The Whistle", R.drawable.leigh_anne));
        listMentors.add(new Mentor("Tryphosa Senoamadi", "Focus building", R.drawable.tryposa));
        listMentors.add(new Mentor("Ennie Phungo", "Cnr Lovedale & Plein Street", R.drawable.ennie));
        listMentors.add(new Mentor("Ruth Katz", "Ruth Katz Consulting", R.drawable.ruth));
        listMentors.add(new Mentor(" Ayesha Malagas", "Stars Wellness", R.drawable.ayesha));
        listMentors.add(new Mentor("Peter Guess", "Peter Guess Therapist", R.drawable.peter_guess));

        //Set lists of items to the adapter
        RecyclerView.Adapter adapter = new MentorsDataAdapter(listMentors);
        recyclerView.setAdapter(adapter);

        //Handles clicks in Recycler view items
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener
                .OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //handle click events here
                Mentor mentor = listMentors.get(position);

                Intent intent = new Intent(MentorsActivity.this, MentorProfileActivity.class);
                intent.putExtra("mentor",mentor);
                startActivity(intent);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                //handle longClick if any
            }
        }));


        /*
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            //We use gesture detector to detect whether is it a single tap
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(),new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            //this methods handle clicks on each item
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    Toast.makeText(getApplicationContext(), (CharSequence) listMentors.get(position), Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        */
    }
}
