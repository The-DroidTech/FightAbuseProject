package com.irinnovative.onepagesigninsignup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.irinnovative.onepagesigninsignup.adapter.AbuseCustomAdapter;
import com.irinnovative.onepagesigninsignup.pojo.Abuse;

import java.util.ArrayList;


public class TwoFragment extends Fragment {
     //RecyclerView
     ListView lvAbuse;
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
        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        listAbuse.add(new Abuse("Physical Abuse"));
        listAbuse.add(new Abuse("Emotional/Verbal Abuse"));
        listAbuse.add(new Abuse("Sexual Abuse"));
        listAbuse.add(new Abuse("Digital Abuse"));
        listAbuse.add(new Abuse("Financial Abuse"));

        rv.setAdapter(new AbuseCustomAdapter(listAbuse));
        return rv;
        //return inflater.inflate(R.layout.fragment_two, container, false);
    }
/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvAbuse = (ListView) getActivity().findViewById(R.id.card_recycler_view);
        AbuseAdapter adapter = new AbuseAdapter(getActivity()),lvAbuse);
        lvAbuse.setAdapter(adapter);

       lvAbuse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), AbuseActivity.class);
                intent.putExtra("content",listAbuse.get(position));
                startActivity(intent);
            }
        });

*/

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        listAbuse = null;
    }

    public void populate()
    {

    }
}
