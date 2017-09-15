package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Sos;

public class SosDetailsActivity extends AppCompatActivity {

    private TextInputEditText sosContact1, sosContact2, sosContact3, sosMessage;
    private Button btnUpdate;
    private Button btnSignOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_details);

        sosContact1 = (TextInputEditText) findViewById(R.id.sos1);
        sosContact2 = (TextInputEditText) findViewById(R.id.sos2);
        sosContact3 = (TextInputEditText) findViewById(R.id.sos3);
        sosMessage = (TextInputEditText) findViewById(R.id.message_update);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnSignOut = (Button) findViewById(R.id.btnSignout);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("sosmessage");


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sos sos = new Sos(sosContact1.getText().toString(), sosContact2.getText().toString(), sosContact3.getText().toString()
                        , sosMessage.getText().toString());


                myRef.child("sos_id").push().setValue(sos);
                sosContact1.setText("");
                sosContact2.setText("");
                sosContact3.setText("");
                sosMessage.setText("");

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
