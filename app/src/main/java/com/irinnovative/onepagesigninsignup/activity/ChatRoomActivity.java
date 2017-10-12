package com.irinnovative.onepagesigninsignup.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Chat;
import com.spark.submitbutton.SubmitButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ChatRoomActivity extends AppCompatActivity {
    private Button create_room;
    private EditText room_name;
    private SubmitButton create_room1;

    private ListView roomList;
    private ArrayAdapter<String> roomAdapter;
    private ArrayList<String> list_of_rooms;

    private String userName;
    private String roomName;
    private String chatkey = "Chat";

    private DatabaseReference databaseReference;
    private Chat chat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);


        //create_room = (Button)findViewById(R.id.btnAddRoom);

        create_room1 = (SubmitButton) findViewById(R.id.btnAddRoom1);
        room_name = (EditText) findViewById(R.id.etRoomName);
        roomList = (ListView) findViewById(R.id.lvListRooms);

        list_of_rooms = new ArrayList<>();

        roomAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_of_rooms);

        roomList.setAdapter(roomAdapter);


        //databaseReference = FirebaseDatabase.getInstance().getReference().getRoot();
        databaseReference = FirebaseDatabase.getInstance().getReference().getRoot().child("ChatGroups");


        request_name();

        /*
        create_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Map<String,Object> map = new HashMap<String, Object>();
                map.put(room_name.getText().toString(),"");
                databaseReference.updateChildren(map);
                room_name.setText(null);

            }
        });

        */


        create_room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                roomName = room_name.getText().toString();
                Map<String, Object> map = new HashMap<>();
                map.put(roomName, "");
                databaseReference.updateChildren(map);
                room_name.setText(null);

            }
        });



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterator iterator = dataSnapshot.getChildren().iterator();


                Set<String> set = new HashSet<>();

                while (iterator.hasNext()) {

                    //get rooms
                    set.add(((DataSnapshot) iterator.next()).getKey());

                }

                list_of_rooms.clear();
                list_of_rooms.addAll(set);

                roomAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        roomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ChatRoomActivity.this, ChatActivity.class);
                //roomName = ((TextView) view).getText().toString();
                intent.putExtra("Room_name", roomName);
                intent.putExtra("User_name", userName);
                startActivity(intent);
            }
        });


    }


    private void request_name() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter your username!");
        final EditText editText = new EditText(this);

        builder.setView(editText);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                userName = editText.getText().toString();

                if (!TextUtils.isEmpty(userName)) {
                    //ok
                    editText.setError("Enter Username");
                } else {

                    request_name();
                }


            }
        }).setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                request_name();
            }
        });

        builder.show();


    }

}
