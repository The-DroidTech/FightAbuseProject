package com.irinnovative.onepagesigninsignup.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.irinnovative.onepagesigninsignup.IconTextTabsActivity;
import com.irinnovative.onepagesigninsignup.InstitutionActivity;
import com.irinnovative.onepagesigninsignup.MentorsActivity;
import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Chat;
import com.irinnovative.onepagesigninsignup.pojo.Person;
import com.irinnovative.onepagesigninsignup.pojo.Sos;
import com.spark.submitbutton.SubmitButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button create_room;
    private EditText room_name;
    private SubmitButton create_room1;

    private ListView roomList;
    private ArrayAdapter<String> roomAdapter;
    private ArrayList<String> list_of_rooms;

    private String userName;
    private String roomName;
    private String chatkey = "Chat";

    private DatabaseReference databaseReference,profReference;
    private FirebaseUser user;
    private Person person;
    private Chat chat;
    ImageView sos;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request_name();
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //create_room = (Button)findViewById(R.id.btnAddRoom);



        //create_room1 = (SubmitButton) findViewById(R.id.btnAddRoom1);
        //room_name = (EditText) findViewById(R.id.etRoomName);
        roomList = (ListView) findViewById(R.id.lvListRooms);

        list_of_rooms = new ArrayList<>();

        roomAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_of_rooms);

        roomList.setAdapter(roomAdapter);


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

                Intent intent = new Intent(NavigationActivity.this, ChatActivity.class);
                //roomName = ((TextView) view).getText().toString();
                intent.putExtra("Room_name", list_of_rooms.get(position));
                intent.putExtra("User_name", userName);
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
            Intent intent = new Intent(this,ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_learn) {
            Intent intent = new Intent(this,IconTextTabsActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_mentor) {
            Intent intent = new Intent(this,MentorsActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_report) {
            Intent intent = new Intent(this,ContactsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_support) {
            Intent intent = new Intent(this,InstitutionActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_book) {
            Intent intent = new Intent(this,BooksActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_testimony) {
            Intent intent = new Intent(this,TestomoniesActivity.class);
            startActivity(intent);

        } else if (id== R.id.log_out)
        {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, MainActivity.class));
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
                Map<String, Object> map = new HashMap<>();
                map.put(roomName, "");
                databaseReference.updateChildren(map);
                room_name.setText(null);


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
                request_name();
            }
        });

        builder.show();


    }
}
