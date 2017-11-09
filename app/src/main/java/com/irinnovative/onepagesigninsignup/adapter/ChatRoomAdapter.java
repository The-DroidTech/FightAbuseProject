package com.irinnovative.onepagesigninsignup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.ChatRoom;

import java.util.ArrayList;

public class ChatRoomAdapter extends BaseAdapter {

    private ArrayList<ChatRoom> chatRooms;
    private static LayoutInflater inflater=null;
    
    public ChatRoomAdapter(Context context, ArrayList<ChatRoom> rooms) {
        chatRooms = rooms;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return chatRooms.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView roomName = (TextView)vi.findViewById(R.id.tvRoomName); // title
        TextView roomDesc = (TextView)vi.findViewById(R.id.tvDesc);
        // artist name

        ChatRoom chatRoom = chatRooms.get(position);
        
        // Setting all values in listview
        roomName.setText(chatRoom.getRoomName());
        roomDesc.setText(chatRoom.getRoomDescription());

        return vi;
    }
}