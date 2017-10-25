package com.irinnovative.onepagesigninsignup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.irinnovative.onepagesigninsignup.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatActivity extends AppCompatActivity
{

    private Button sendBtn;
    private TextView recieveMsg;
    private EditText sendMsg;

    private ListView listChat;
    private ArrayAdapter<String> chatAdapter;
    private ArrayList<String> list_of_chats;



    DatabaseReference rootRoomName;


    String userName, roomName, chatUserName, chatMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat);


        sendBtn = (Button)findViewById(R.id.btnSendMessage);
        //recieveMsg =(TextView)findViewById(R.id.txtViewMessage);
        sendMsg =(EditText)findViewById(R.id.etTypeMessage);


        listChat = (ListView) findViewById(R.id.lvViewMessage);

        list_of_chats = new ArrayList<>();

        chatAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_of_chats);

        listChat.setAdapter(chatAdapter);





        roomName = (String) getIntent().getExtras().get("Room_name");
        userName = (String) getIntent().getExtras().get("User_name");



        setTitle(roomName);


        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);


        rootRoomName = FirebaseDatabase.getInstance().getReference().getRoot().child("ChatGroups").child(roomName);


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference childRoot = rootRoomName.push();

                Map<String, Object> map = new HashMap<>();

                map.put("name", userName);
                map.put("message", sendMsg.getText().toString());

                childRoot.updateChildren(map);


                sendMsg.setText("");
                //sendMsg.remo

            }
        });


       /* sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(sendMsg, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        */

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

    private void update_message(DataSnapshot dataSnapshot)
    {

        chatUserName = (String) dataSnapshot.child("name").getValue();
        chatMessage =  (String) dataSnapshot.child("message").getValue();


        //recieveMsg.append(chatUserName + ": " +  chatMessage + "\n\n" );
        chatAdapter.add(chatUserName + "\n" + chatMessage);


        chatAdapter.notifyDataSetChanged();

    }


}
