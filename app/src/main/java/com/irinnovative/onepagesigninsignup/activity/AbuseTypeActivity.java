package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.adapter.AbuseCustomAdapter;
import com.irinnovative.onepagesigninsignup.pojo.Abuse;
import com.irinnovative.onepagesigninsignup.pojo.Mentor;
import com.irinnovative.onepagesigninsignup.pojo.RecyclerItemClickListener;

import java.util.ArrayList;

public class AbuseTypeActivity extends AppCompatActivity {
    RecyclerView lvAbuse;
    ArrayList<Abuse> listAbuse = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abuse_type);

        populate();

        lvAbuse = (RecyclerView) findViewById(R.id.card_recycler_view);
        AbuseCustomAdapter adapter = new AbuseCustomAdapter(listAbuse);
        lvAbuse.setAdapter(adapter);

        lvAbuse.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        lvAbuse.setLayoutManager(layoutManager);

        lvAbuse.addOnItemTouchListener(new RecyclerItemClickListener(this, lvAbuse, new RecyclerItemClickListener
                .OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //handle click events here
                Abuse abuse = listAbuse.get(position);

                Intent intent = new Intent(getBaseContext(), AbuseActivity.class);
                intent.putExtra("content",abuse);
                startActivity(intent);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                //handle longClick if any
            }
        }));
    }


    public void populate()
    {


        final ArrayList<Mentor> listMentors;

        listAbuse.add(new Abuse("Physical Abuse","Physical abuse is any intentional act causing injury or trauma to another person or animal by way of bodily contact. In most cases, children are the victims of physical abuse, but adults can also be victims, as in cases of domestic violence or workplace aggression." + "\n\n" + "Effects of Physical Abuse " + "\n\n" + "The effects of physical abuse can be both acute and far-reaching. The immediate effect of physical abuse may be a bruise or a cut, but the long-term effect may be drastic - like post-traumatic stress disorder. Moreover, the effects of physical abuse can be felt by loved ones and, especially, children of both the victim and abuser. The psychological effects of physical abuse should not be underestimated." + "\n\n" + "Unfortunately, some of the longest-lasting and most debilitating effects of physical abuse are psychological in nature. Depression is the primary psychological response to physical abuse but drug and alcohol abuse is also common. Abused women have a 16-times greater risk of abusing alcohol and a 9-times greater risk of abusing drugs when compared to non-abused women",R.drawable.newphysicalabusepic));
        listAbuse.add(new Abuse("Emotional/Verbal Abuse","An attempt to control a partner through the manipulation of their self-esteem, sense of personal security, " +
                "relationships with others, and/or their perception of reality. Often it results in the victim feeling worthless and responsible for the abuse.",R.drawable.emotional));
        listAbuse.add(new Abuse("Sexual Abuse","Any behaviors that impact a person’s ability to control their sexual activity or the circumstances in which sexual activity occurs,Most victims and perpetrators know each other. Immediate reactions to sexual abuse include shock, fear or disbelief. Long-term symptoms include anxiety, fear or post-traumatic stress disorder,while efforts to treat sex offenders remain unpromising, psychological interventions for survivors — especially group therapy — appears effective.",R.drawable.sexabuse));
        listAbuse.add(new Abuse("Digital Abuse","This is a form of emotional/verbal abuse that uses technology or social media to intimidate, harass, bully, stalk or threaten a current or ex-partner.",R.drawable.digiital));
        listAbuse.add(new Abuse("Financial Abuse","The use of finances or access to finances to control a partner. It’s one of the powerful forms of abuse, and common method of " +
                "entrapping a partner in the relationship. It’s often given as the reason that victims of abuser stayed in or returned to an abusive relationship.",R.drawable.financial));
        listAbuse.add(new Abuse("Child abuse ","Child abuse is any action by another person – adult or child – that causes significant harm to a child. It can be physical, sexual or emotional, but can just as often be about a lack of love, care and attention. We know that neglect, whatever form it takes, can be just as damaging to a child as physical abuse.",R.drawable.childabuse));
        // listAbuse.add(new Abuse("Discriminatory abuse","Discriminatory abuse is when someone picks on you or treats you unfairly because something about you is different. This can include unfair or less favourable treatment due to a person's race, gender, age, disability, religion, sexuality, appearance or cultural background.",R.drawable.discrim ));
    }
}
