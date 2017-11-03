package com.irinnovative.onepagesigninsignup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.adapter.ChatAdapter;
import com.irinnovative.onepagesigninsignup.pojo.ChatMessage;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChatActivity extends AppCompatActivity {

    private Button sendBtn;
    private TextView recieveMsg;
    private EditText sendMsg;
    private ChatAdapter adapter;
    private ListView listChat;
    private FirebaseUser user;
    //private ArrayAdapter<String> chatAdapter;
    private ArrayList<ChatMessage> list_of_chats;


    DatabaseReference rootRoomName;


    String userName, roomName, chatUserName, chatMessageTxt, chatDate, userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user = FirebaseAuth.getInstance().getCurrentUser();
        initControls();
        // sendBtn = (Button)findViewById(R.id.btnSendMessage);
        //recieveMsg =(TextView)findViewById(R.id.txtViewMessage);
        // sendMsg =(EditText)findViewById(R.id.etTypeMessage);


        //listChat = (ListView) findViewById(R.id.lvViewMessage);

        list_of_chats = new ArrayList<>();

        //chatAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_of_chats);

        //listChat.setAdapter(chatAdapter);


        roomName = (String) getIntent().getExtras().get("Room_name");
        userName = (String) getIntent().getExtras().get("User_name");


        setTitle(roomName);


        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);


        rootRoomName = FirebaseDatabase.getInstance().getReference().getRoot().child("ChatGroups").child(roomName);


        listChat = (ListView) findViewById(R.id.lvViewMessage);
        sendMsg = (EditText) findViewById(R.id.etTypeMessage);
        sendBtn = (Button) findViewById(R.id.btnSendMessage);

        // TextView meLabel = (TextView) findViewById(R.id.meLbl);
        //TextView companionLabel = (TextView) findViewById(R.id.friendLabel);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        //companionLabel.setText("My Buddy");


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = sendMsg.getText().toString();
                if (TextUtils.isEmpty(messageText)) {
                    return;
                }

                DatabaseReference childRoot = rootRoomName.push();

                ChatMessage chatMessage = new ChatMessage();
                // chatMessage.setId(childRoot + "");//dummy
                chatMessage.setUserName(userName);
                chatMessage.setMessage(messageText);
                chatMessage.setDate(DateFormat.getDateTimeInstance().format(new Date()));
                chatMessage.setMe(true);

                // childRoot.setValue(chatMessage);


                Map<String, Object> map = new HashMap<>();

                map.put("name", userName);
                map.put("message", sendMsg.getText().toString());
                map.put("date", chatMessage.getDate());
                map.put("userId", user.getUid());

                childRoot.updateChildren(map);

                sendMsg.setText("");

                //displayMessage(chatMessage);
            }
        });



        /*
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

    */
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

    private void update_message(DataSnapshot dataSnapshot) {

        chatUserName = (String) dataSnapshot.child("name").getValue();
        chatMessageTxt = (String) dataSnapshot.child("message").getValue();
        chatDate = (String) dataSnapshot.child("date").getValue();
        userId = (String) dataSnapshot.child("userId").getValue();


        //recieveMsg.append(chatUserName + ": " +  chatMessage + "\n\n" );

        ChatMessage chatMessage = new ChatMessage();
        //adapter.add(chatUserName + "\n" + chatMessage);

        chatMessage.setUserName(chatUserName);
        chatMessage.setMessage(chatMessageTxt);
        chatMessage.setDate(chatDate);
        chatMessage.setUserId(userId);
        if(user.getUid().equals(chatMessage.getUserId()))
        {
            chatMessage.setMe(true);
        }
        else {
            chatMessage.setMe(false);
        }



        adapter.add(chatMessage);

        //displayMessage(chatMessage);

        listChat.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

    }


    private void initControls() {
        listChat = (ListView) findViewById(R.id.lvViewMessage);
        sendMsg = (EditText) findViewById(R.id.etTypeMessage);
        sendBtn = (Button) findViewById(R.id.btnSendMessage);

        // TextView meLabel = (TextView) findViewById(R.id.meLbl);
        //TextView companionLabel = (TextView) findViewById(R.id.friendLabel);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        //companionLabel.setText("My Buddy");

        loadDummyHistory();


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = sendMsg.getText().toString();
                if (TextUtils.isEmpty(messageText)) {
                    return;
                }

                DatabaseReference childRoot = rootRoomName.push();

                ChatMessage chatMessage = new ChatMessage();
                // chatMessage.setId(childRoot + "");//dummy
                chatMessage.setUserName(userName);
                chatMessage.setMessage(messageText);
                chatMessage.setDate(DateFormat.getDateTimeInstance().format(new Date()));
                chatMessage.setMe(true);
                chatMessage.setUserId(userId);

                // childRoot.setValue(chatMessage);


                Map<String, Object> map = new HashMap<>();

                map.put("name", userName);
                map.put("message", sendMsg.getText().toString());
                map.put("date", chatMessage.getDate());
                map.put("userId", chatMessage.getUserId());

                childRoot.updateChildren(map);

                sendMsg.setText("");

            }
        });


    }

    public void displayMessage(ChatMessage message) {
        adapter.add(message);
        adapter.notifyDataSetChanged();
        scroll();
    }

    private void scroll() {
        listChat.setSelection(listChat.getCount() - 1);
    }


    private void loadDummyHistory() {

        list_of_chats = new ArrayList<ChatMessage>();

        /*ChatMessage msg = new ChatMessage();
        //msg.setId(1 + "");
        msg.setMe(false);
        msg.setMessage("Hi");
        msg.setDate(DateFormat.getDateTimeInstance().format(new Date()));
        list_of_chats.add(msg);
        ChatMessage msg1 = new ChatMessage();
        //msg1.setId(2+ "");
        msg1.setMe(false);
        msg1.setMessage("How r u doing???");
        msg1.setDate(DateFormat.getDateTimeInstance().format(new Date()));
        list_of_chats.add(msg1);*/

        adapter = new ChatAdapter(ChatActivity.this, new ArrayList<ChatMessage>());
        listChat.setAdapter(adapter);

        for (int i = 0; i < list_of_chats.size(); i++) {
            ChatMessage message = list_of_chats.get(i);
            displayMessage(message);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {

            onBackPressed();
        }


        return super.onOptionsItemSelected(item);
    }
    
}
