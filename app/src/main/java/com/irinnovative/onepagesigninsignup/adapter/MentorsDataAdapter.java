package com.irinnovative.onepagesigninsignup.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Mentor;

import java.util.ArrayList;

/**
 * Created by codetribe on 10/11/2017.
 */

public class MentorsDataAdapter extends RecyclerView.Adapter<MentorsDataAdapter.ViewHolder>
{
    private ArrayList<Mentor> mentors;

    public MentorsDataAdapter(ArrayList<Mentor> mentors) {
        this.mentors = mentors;
    }

    @Override
    public MentorsDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mentors_card_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MentorsDataAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(mentors.get(position).getName());
        holder.tv_institution.setText(mentors.get(position).getIntitution());
        holder.img_profile.setImageResource(mentors.get(position).getImage());
    }



    @Override
    public int getItemCount() {
        return mentors.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_institution;
        private ImageView img_profile;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.txt_mentor_name);
            tv_institution = (TextView)view.findViewById(R.id.txt_institution);
            img_profile = (ImageView) view.findViewById(R.id.image_view_mentors);
        }
    }

}
