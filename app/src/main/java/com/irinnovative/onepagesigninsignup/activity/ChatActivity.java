package com.irinnovative.onepagesigninsignup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.irinnovative.onepagesigninsignup.R;

import java.util.HashMap;
import java.util.Map;

public class ChatActivity extends AppCompatActivity
{
    private Button sendMessageBtn;
    private EditText typeMessageTxt;
    private TextView chat_conversation;

    private String userName, roomName, temp_key, chatUserName, chatMessage;

    private DatabaseReference rootRoomName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        sendMessageBtn = (Button)findViewById(R.id.btnSendMessage);
        typeMessageTxt = (EditText)findViewById(R.id.etTypeMessage);
        chat_conversation = (TextView)findViewById(R.id.txtViewMessage);

        roomName = getIntent().getExtras().get("Room_name").toString();
        userName = getIntent().getExtras().get("User_name").toString();

        setTitle(roomName);


        rootRoomName = FirebaseDatabase.getInstance().getReference().getRoot().child(roomName);

        sendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference childRoot = rootRoomName.push();

                Map<String,Object> map = new HashMap<>();

                map.put("name", userName);
                map.put("message", typeMessageTxt.getText().toString());


                childRoot.updateChildren(map);

            }
        });


        rootRoomName.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                update_message(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                update_message(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void update_message(DataSnapshot dataSnapshot) {

        chatUserName = (String) dataSnapshot.child("name").getValue();
        chatMessage = (String) dataSnapshot.child("message").getValue();


        chat_conversation.append(chatUserName + ": " + chatMessage + "\n\n");
    }


}


