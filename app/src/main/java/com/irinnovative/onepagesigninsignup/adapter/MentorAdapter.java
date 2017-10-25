package com.irinnovative.onepagesigninsignup.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Mentor;

import java.util.ArrayList;

/**
 * Created by codetribe on 7/12/2017.
 */

public class MentorAdapter extends ArrayAdapter<Mentor> {

    /**Resource ID for the background color for this list of words*/

    public MentorAdapter(Activity context, ArrayList<Mentor> words){
        super(context,0,words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Check if the existing view is being refused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Mentor currentMentor = getItem(position);

        TextView nameTextView = (TextView)listItemView.findViewById(R.id.txt_name);
        nameTextView.setText(currentMentor.getName());

        TextView institutionTextView = (TextView)listItemView.findViewById(R.id.txt_institution);
        institutionTextView.setText(currentMentor.getIntitution());


        ImageView imageView =(ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentMentor.getImage());


        return listItemView;

    }

}
