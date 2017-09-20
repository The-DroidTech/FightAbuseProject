package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Person;
import com.irinnovative.onepagesigninsignup.pojo.Sos;

import static android.R.attr.value;

public class SosDetailsActivity extends AppCompatActivity {

    private TextInputEditText sosContact1, sosContact2, sosContact3, sosMessage, username, bio, cellphone;
    private Button btnUpdate;
    private Button btnSignOut;
    private String temp_key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_details);

        username = (TextInputEditText) findViewById(R.id.user_Username);
        bio = (TextInputEditText) findViewById(R.id.user_bio);
        cellphone = (TextInputEditText) findViewById(R.id.user_cellphone);

        sosContact1 = (TextInputEditText) findViewById(R.id.sos1);
        sosContact2 = (TextInputEditText) findViewById(R.id.sos2);
        sosContact3 = (TextInputEditText) findViewById(R.id.sos3);
        sosMessage = (TextInputEditText) findViewById(R.id.message_update);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnSignOut = (Button) findViewById(R.id.btnSignout);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference refProfile = database.getReference("Profile");
        final DatabaseReference refSos = database.getReference("Sos");

        // Read from the database
        refProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Person value = dataSnapshot.getValue(Person.class);
                Sos sos = dataSnapshot.getValue(Sos.class);

                username.setText(value.getUsername());
                bio.setText(value.getBio());
                cellphone.setText(value.getCellphone());

                sosMessage.setText(sos.getMessage());
                sosContact1.setText(sos.getContact1());
                sosContact2.setText(sos.getContact2());
                sosContact3.setText(sos.getContact3());
                //Log.d("TAG", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getParent(),"Failed to read",Toast.LENGTH_SHORT).show();
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp_key = refProfile.push().getKey();
                Person person = new Person(temp_key,username.getText().toString(),bio.getText().toString(),cellphone.getText().toString(),"");
                refProfile.setValue(person);

                Sos sos = new Sos(sosContact1.getText().toString(), sosContact2.getText().toString(), sosContact3.getText().toString()
                        , sosMessage.getText().toString());

                refSos.setValue(sos);

                startActivity(new Intent(SosDetailsActivity.this,ProfileActivity.class));
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getBaseContext(), MainActivity.class));

            }
        });


    }


}
