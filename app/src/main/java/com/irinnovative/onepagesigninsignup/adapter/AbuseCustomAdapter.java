package com.irinnovative.onepagesigninsignup.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Abuse;

import java.util.ArrayList;

/**
 * Created by codetribe on 9/22/2017.
 */

public class AbuseCustomAdapter extends RecyclerView.Adapter<AbuseCustomAdapter.ViewHolder>{
    private ArrayList<Abuse> abuse;

    public AbuseCustomAdapter(ArrayList<Abuse> abuse) {
        this.abuse = abuse;
    }
    @Override
    public AbuseCustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(AbuseCustomAdapter.ViewHolder holder, int position) {
        holder.topicTextView.setText(abuse.get(position).getTopic());
      //  holder.descTextView.setText(abuse.get(position).getDesc());
        holder.img_profile.setImageResource(abuse.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return abuse.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView topicTextView,descTextView;
        private ImageView img_profile;
        public ViewHolder(View view) {
            super(view);

            topicTextView = (TextView)view.findViewById(R.id.txt_topic);
          //  descTextView = (TextView) view.findViewById(R.id.txt_desc);
            img_profile = (ImageView) view.findViewById(R.id.image_view_abuse);
        }
    }
}

