package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.adapter.AbuseAdapter;
import com.irinnovative.onepagesigninsignup.pojo.Abuse;
import com.irinnovative.onepagesigninsignup.pojo.Mentor;

import java.util.ArrayList;

public class AbuseTypeActivity extends AppCompatActivity {
    ListView lvAbuse;
    ArrayList<Abuse> listAbuse = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abuse_type);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Types of Abuse");

        populate();

        lvAbuse = (ListView) findViewById(R.id.card_list_view);
        AbuseAdapter adapter = new AbuseAdapter(this,listAbuse);
        lvAbuse.setAdapter(adapter);
        lvAbuse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Abuse abuse = listAbuse.get(position);

                Intent intent = new Intent(getBaseContext(), AbuseActivity.class);
                intent.putExtra("content", abuse);
                startActivity(intent);
            }
        });
/*
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
                intent.putExtra("content", abuse);
                startActivity(intent);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                //handle longClick if any
            }
        }));
        */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {

            onBackPressed();
        }


        return super.onOptionsItemSelected(item);
    }


    public void populate() {


        final ArrayList<Mentor> listMentors;

        listAbuse.add(new Abuse("Physical Abuse", "Physical abuse is any intentional act causing injury or trauma to another person or animal by way of bodily contact. In most cases, children are the victims of physical abuse, but adults can also be victims, as in cases of domestic violence or workplace aggression." + "\n\n" + "Effects of Physical Abuse " + "\n\n" + "The effects of physical abuse can be both acute and far-reaching. The immediate effect of physical abuse may be a bruise or a cut, but the long-term effect may be drastic - like post-traumatic stress disorder. Moreover, the effects of physical abuse can be felt by loved ones and, especially, children of both the victim and abuser. The psychological effects of physical abuse should not be underestimated." + "\n\n" + "Unfortunately, some of the longest-lasting and most debilitating effects of physical abuse are psychological in nature. Depression is the primary psychological response to physical abuse but drug and alcohol abuse is also common. Abused women have a 16-times greater risk of abusing alcohol and a 9-times greater risk of abusing drugs when compared to non-abused women", R.drawable.newphysicalabusepic));
        listAbuse.add(new Abuse("Emotional/Verbal Abuse", "An attempt to control a partner through the manipulation of their self-esteem, sense of personal security, " +
                "relationships with others, and/or their perception of reality. Often it results in the victim feeling worthless and responsible for the abuse." + "\n"+ "Effects of long-term emotional abuse by significant others, boyfriends or girlfriends include:\n" +
                "\n" +
                "Depression\n" +
                "Withdrawal\n" +
                "Low self-esteem and self-worth\n" +
                "Emotional instability\n" +
                "Sleep disturbances\n" +
                "Physical pain without cause\n" +
                "Suicidal ideation, thoughts or attempts\n" +
                "Extreme dependence on the abuser\n" +
                "Underachievement\n" +
                "Inability to trust\n" +
                "Feeling trapped and alone\n" +
                "Substance abuse",R.drawable.emotional));
        listAbuse.add(new Abuse("Sexual Abuse", "Any behaviors that impact a person’s ability to control their sexual activity or the circumstances in which sexual activity occurs,Most victims and perpetrators know each other. Immediate reactions to sexual abuse include shock, fear or disbelief. Long-term symptoms include anxiety, fear or post-traumatic stress disorder,while efforts to treat sex offenders remain unpromising, psychological interventions for survivors — especially group therapy — appears effective.", R.drawable.sexabuse));
        listAbuse.add(new Abuse("Digital Abuse", "This is a form of emotional/verbal abuse that uses technology or social media to intimidate, harass, bully, stalk or threaten a current or ex-partner.", R.drawable.digiital));
        listAbuse.add(new Abuse("Financial Abuse", "The use of finances or access to finances to control a partner. It’s one of the powerful forms of abuse, and common method of " +
                "entrapping a partner in the relationship. It’s often given as the reason that victims of abuser stayed in or returned to an abusive relationship.", R.drawable.financial));
        listAbuse.add(new Abuse("Child abuse ", "Child abuse is any action by another person – adult or child – that causes significant harm to a child. It can be physical, sexual or emotional, but can just as often be about a lack of love, care and attention. We know that neglect, whatever form it takes, can be just as damaging to a child as physical abuse.", R.drawable.childabuse));
        listAbuse.add(new Abuse("Psychological abuse", "Psychological abuse is common and yet few understand the psychological abuse definition enough to spot it. Without the visible signs of physical abuse, psychological abuse can stay hidden for years." + "\n\n" + "Effects of Psychological abuse " + "\n\n" + "Psychological abuse, though, can be just as devastating as physical abuse. Psychological abuse can affect your inner thoughts and feelings as well as exert control over your life. You may feel uncertain of the world around you and unsafe in your own home. Psychological abuse can destroy intimate relationships, friendships and even your own relationship with yourself, Psychological abuse also applies to children and may impair their development into a healthy adult" + "\n\n" + "Psychological abuse signs and symptoms may start small at first as the abuser \"tests the waters\" to see what the other person will accept, but before long the psychological abuse builds into something that can be frightening and threatening.", R.drawable.psychological));
        listAbuse.add(new Abuse("Verbal abuse", "Verbal abuse is the only type of abuse that can affect every single person with any type of communication ability or understanding. You may be assaulted by verbal abuse at work, at home, at school, on the road, or walking through a park, and there is nothing you can do to prevent it. You could even be a victim of verbal abuse if you live alone because if your self-talk, the voice in your head, diminishes you or your belief in yourself in any way, then you subject yourself to verbal abuse when you allow your inner critic to put you down. No one, anywhere, is immune to verbal abuse.  any language or behavior that seeks to coerce its victim to doubt their perceptions or their abilities and subjugate themselves to the abuser." + "\n\n" + "Effects of verbal abuse " + "\n\n" + "The effects of verbal abuse on children, women and men follow the same general principle: verbal abuse causes people to feel fear. However, victims may deny or not recognize their anxiety and feelings of wanting to get away as fear of the abuser." + "\n\n" + "The effects of verbal abuse on women and men range from confusion to symptoms of, or the development of, mental disorders. There is substantially more research studies concerning female victims of verbal abuse, but even so, there are commonalities among victims in general.", R.drawable.verbalabuse));
        listAbuse.add(new Abuse("Domestic violence", "Domestic violence occurs when one partner exerts control over the other while dating, during marriage, or cohabitation. Domestic abuse involves injuring someone, such as a spouse, partner, or other family member within the domestic setting. The injuries caused by domestic violence can be either physical or emotional and the effects of domestic abuse often result in lifelong issues long after the victim has left the abusive environment." + "\n\n" + "Effects of Domestic violence" + "\n\n" + "Perpetrators of domestic abuse have serious mental health issues and, in many instances, a self-perception not based in reality. No mistake, action, or sin makes anyone deserving of domestic violence. Abusers want to control their partners and use repetitive accusations and physical abuse to tear down the victim's self worth and, thus, their personal power to escape the situation. They often deny that the abuse occurred, or deny that what they did constitutes abuse, leaving the victim doubting the abuse took place." + "\n\n" + "There is no typical victim profile for domestic violence and abuse. All types of domestic violence can occur in every socioeconomic group, educational and religious background, age group, culture, and nation; and it can happen in same sex relationships as well as traditional heterosexual ones. Even though a typical victim doesn't exist, certain women do have a greater risk for becoming victims of domestic violence and abuse", R.drawable.domestic));


    }
}
