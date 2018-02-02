package com.irinnovative.onepagesigninsignup.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.irinnovative.onepagesigninsignup.InstitutionActivity;
import com.irinnovative.onepagesigninsignup.PhoneSigninActivity;
import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.adapter.ChatRoomAdapter;
import com.irinnovative.onepagesigninsignup.pojo.Chat;
import com.irinnovative.onepagesigninsignup.pojo.ChatRoom;
import com.irinnovative.onepagesigninsignup.pojo.Person;
import com.irinnovative.onepagesigninsignup.pojo.Sos;
import com.spark.submitbutton.SubmitButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button create_room;
    private EditText room_name;
    private TextView editNavUsername;
    private SubmitButton create_room1;

    private ListView roomList;
    private ChatRoomAdapter roomAdapter;


    private ChatRoomAdapter chatRoomChatRoomAdapter;
    private ChatRoom chatRoom;

    private ArrayList<ChatRoom> list_of_rooms;
    private ArrayList<String> list_of_rooms_id;
    private ArrayList<String> list_of_room;

    private String userName;
    private String roomName;
    private String roomDescription;
    private String chatkey = "Chat";

    private DatabaseReference databaseReference, profReference;
    private FirebaseUser user;
    private Person person;
    private Chat chat;
    ImageView sos;
    int count = 0;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = getBaseContext();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View hView = navigationView.getHeaderView(0);
        final TextView nav_userName = (TextView) hView.findViewById(R.id.drawerTextName);
        final TextView nav_userPhone = (TextView) hView.findViewById(R.id.drawerTextEmail);
        final ImageView nav_userImage = (ImageView) hView.findViewById(R.id.drawerImageView);


        databaseReference = FirebaseDatabase.getInstance().getReference().getRoot().child("ChatGroups");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        profReference = database.getReference().child("Profile").child(user.getUid());


        profReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Person value = dataSnapshot.getValue(Person.class);
                Sos sosValue = dataSnapshot.getValue(Sos.class);

                if (value != null) {
                    userName = value.getUsername();
                    nav_userName.setText(userName);
                    nav_userPhone.setText(value.getCellphone());
                    Glide.with(getApplicationContext()).load(value.getImageUrl()).into(nav_userImage);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        chatRoom = new ChatRoom();
        chatRoom.setRoomName(roomName);
        chatRoom.setRoomDescription(roomDescription);









        //create_room = (Button)findViewById(R.id.btnAddRoom);


        //create_room1 = (SubmitButton) findViewById(R.id.btnAddRoom1);
        //room_name = (EditText) findViewById(R.id.etRoomName);
        roomList = (ListView) findViewById(R.id.lvListRooms);




        list_of_rooms = new ArrayList<>();


       // chatRoomChatRoomAdapter = new ChatRoomAdapter(NavigationActivity.this,list_of_rooms);

        //roomAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_of_rooms);
        //roomList.setAdapter(chatRoomChatRoomAdapter);

        //databaseReference = FirebaseDatabase.getInstance().getReference().getRoot();




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


        /*create_room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                roomName = room_name.getText().toString();
                Map<String, Object> map = new HashMap<>();
                map.put(roomName, "");
                databaseReference.updateChildren(map);
                room_name.setText(null);

            }
        });
*/

        /*
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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
        */

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                list_of_rooms = new ArrayList<>();
                list_of_rooms_id = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.i("Ygritte", snapshot.toString());
                    ChatRoom chatRoom = snapshot.getValue(ChatRoom.class);
                    list_of_rooms.add(chatRoom);
                    list_of_rooms_id.add(snapshot.getKey());
                }
                roomAdapter = new ChatRoomAdapter(context,list_of_rooms);
                roomAdapter.notifyDataSetChanged();
                roomList.setAdapter(roomAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

        /*
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

                list_of_room = new ArrayList<>();

                list_of_rooms.addAll(set);



                roomAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        */

        roomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(NavigationActivity.this, ChatActivity.class);
                roomName = list_of_rooms.get(position).getRoomName();
                String roomId = list_of_rooms_id.get(position);
                intent.putExtra("Room_name", roomName);
                intent.putExtra("User_name", userName);
                intent.putExtra("room_id", roomId);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_learn) {
            Intent intent = new Intent(this, AbuseTypeActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_report) {
            Intent intent = new Intent(this, ContactsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_support) {
            Intent intent = new Intent(this, InstitutionActivity.class);
            startActivity(intent);

        } else if (id == R.id.log_out) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, MainActivity.class));
        }
        else if (id == R.id.nav_about)
        {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void request_name() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter room name!");
        final EditText editText = new EditText(this);

        builder.setView(editText);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                roomName = editText.getText().toString();

                //roomName = room_name.getText().toString();
                //Map<String, Object> map = new HashMap<>();
                //map.put(roomName, "");
                //databaseReference.updateChildren(map);
                //room_name.setText(null);


                if (!TextUtils.isEmpty(roomName)) {
                    //ok
                    editText.setError("Enter room name");
                } else {

                    request_name();
                }


            }
        }).setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
               // request_name();
            }
        });

        request_room_desc();

        builder.show();


    }


    private void request_room_desc()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter room description!");
        final EditText editText = new EditText(this);

        builder.setView(editText);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                roomDescription = editText.getText().toString();

                //roomName = room_name.getText().toString();
                Map<String, Object> map = new HashMap<>();
                map.put("roomName", roomName);
                map.put("roomDescription", roomDescription);
                //databaseReference.updateChildren(map);
              //  room_name.setText(null);


                if (!TextUtils.isEmpty(roomDescription)) {
                    //ok
                    editText.setError("Enter room description!");
                } else {

                    request_room_desc();
                }


            }
        }).setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // request_name();
            }
        });

        builder.show();

    }
}
