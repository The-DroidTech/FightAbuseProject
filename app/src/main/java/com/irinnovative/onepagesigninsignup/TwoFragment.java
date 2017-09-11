package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.irinnovative.onepagesigninsignup.activity.AbuseActivity;
import com.irinnovative.onepagesigninsignup.adapter.AbuseAdapter;
import com.irinnovative.onepagesigninsignup.pojo.Abuse;

import java.util.ArrayList;


public class TwoFragment extends Fragment {
    private ListView lvAbuse;
    ArrayList<Abuse> listAbuse = new ArrayList<>();

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populate();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvAbuse = (ListView) getActivity().findViewById(R.id.lvAbuse);
        AbuseAdapter adapter = new AbuseAdapter(getActivity(),listAbuse);
        lvAbuse.setAdapter(adapter);

        lvAbuse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), AbuseActivity.class);
                intent.putExtra("content",listAbuse.get(position));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        listAbuse = null;
    }

    public void populate()
    {
        listAbuse.add(new Abuse("Physical Abuse","Any intentional use of physical force with the intent to control a partner through fear or injuryPhysical abuse in a relationship often starts gradually, such as with a push or a slap, and then becomes progressively worse over time, physical violence is always illegal. If you have been physically abused, there are things you can do to get support..",R.drawable.physicalabuse));
        listAbuse.add(new Abuse("Emotional/Verbal Abuse","An attempt to control a partner through the manipulation of their self-esteem, sense of personal security, " +
                "relationships with others, and/or their perception of reality. Often it results in the victim feeling worthless and responsible for the abuse.",R.drawable.emotional));
        listAbuse.add(new Abuse("Sexual Abuse","Any behaviors that impact a person’s ability to control their sexual activity or the circumstances in which sexual activity occurs,Most victims and perpetrators know each other. Immediate reactions to sexual abuse include shock, fear or disbelief. Long-term symptoms include anxiety, fear or post-traumatic stress disorder,while efforts to treat sex offenders remain unpromising, psychological interventions for survivors — especially group therapy — appears effective.",R.drawable.sexabuse));
        listAbuse.add(new Abuse("Digital Abuse","This is a form of emotional/verbal abuse that uses technology or social media to intimidate, harass, bully, stalk or threaten a current or ex-partner.",R.drawable.digital));
        listAbuse.add(new Abuse("Financial Abuse","The use of finances or access to finances to control a partner. It’s one of the powerful forms of abuse, and common method of " +
                "entrapping a partner in the relationship. It’s often given as the reason that victims of abuser stayed in or returned to an abusive relationship.",R.drawable.financial));

    }
}
