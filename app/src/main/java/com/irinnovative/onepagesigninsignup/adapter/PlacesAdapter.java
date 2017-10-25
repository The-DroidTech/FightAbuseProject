package com.irinnovative.onepagesigninsignup.adapter;

/**
 * Created by Code Tribe on 2017/08/10.
 */

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Place;

import java.util.ArrayList;



/**
 * Created by Code Tribe on 2017/05/29.
 */

public class PlacesAdapter extends ArrayAdapter<Place> {


    public PlacesAdapter(Activity context, ArrayList<Place> contents)
    {
        super(context,0, contents);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listViewItem = convertView;

        if(listViewItem == null)
        {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item_places,parent,false);
        }

        Place currentContent = getItem(position);

        TextView txtName = (TextView) listViewItem.findViewById(R.id.textView_name);
        TextView txtDesc = (TextView) listViewItem.findViewById(R.id.textView_description);
        ImageView imgShow = (ImageView) listViewItem.findViewById(R.id.imageView2);

        //set content
        txtName.setText(currentContent.getName());
        txtDesc.setText(currentContent.getDesc());
        int[] imgUrls = currentContent.getImageURl();
        imgShow.setImageResource(imgUrls[0]);



        return listViewItem;


    }
}
