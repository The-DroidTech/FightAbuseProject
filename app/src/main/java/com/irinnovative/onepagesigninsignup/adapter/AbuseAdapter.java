package com.irinnovative.onepagesigninsignup.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Abuse;

/**
 * Created by Code Tribe on 2017/09/02.
 */

public class AbuseAdapter extends ArrayAdapter<Abuse>{

    public AbuseAdapter(Activity context, int resources){
        super(context,resources);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Check if the existing view is being refused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_abuse,parent,false);
        }

        Abuse currentAbuse = getItem(position);

        TextView topicTextView = (TextView)listItemView.findViewById(R.id.txt_topic);
        topicTextView.setText(currentAbuse.getTopic());

        ImageView imageView =(ImageView) listItemView.findViewById(R.id.icon_abuse);
        imageView.setImageResource(currentAbuse.getImg());


        return listItemView;

    }
}
