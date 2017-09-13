package com.irinnovative.onepagesigninsignup.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.irinnovative.onepagesigninsignup.IconTextTabsActivity;
import com.irinnovative.onepagesigninsignup.InstitutionActivity;
import com.irinnovative.onepagesigninsignup.MentorsActivity;
import com.irinnovative.onepagesigninsignup.R;

public class HomeActivity extends AppCompatActivity {
    ImageView sos;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       // getSupportActionBar().setTitle("HOME PAGE");
    }



    public void learn (View v){
        Intent intent = new Intent(HomeActivity.this,IconTextTabsActivity.class);
        startActivity(intent);
    }


    public void contacts(View v){
        Intent intent = new Intent(HomeActivity.this,ContactsActivity.class);
        startActivity(intent);
    }

    public void institution(View v){
        Intent intent = new Intent(HomeActivity.this,InstitutionActivity.class);
        startActivity(intent);
    }

    public void support(View v){
        Intent intent = new Intent(HomeActivity.this,SupportGroups.class);
        startActivity(intent);
    }

    public void sos(View v){
        sos = (ImageView) findViewById(R.id.sosButton);
        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(HomeActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialogue_spinner, null);
                mBuilder.setTitle("Are you sure you want to activate?");

                final Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinner);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(HomeActivity.this, android.R.layout.simple_spinner_item
                        ,getResources().getStringArray(R.array.accountType));

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner.setAdapter(adapter);


                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (mSpinner.getSelectedItem().toString().equalsIgnoreCase("Choose account type")) {
                            //Toast.makeText(MainActivity.this,
                            // m = Spinner.getSelectedItem().toString(),
                            //Toast.LENGTH_SHORT).show();

                            dialogInterface.dismiss();
                        }
                        final String text= mSpinner.getSelectedItem().toString();

                        switch(text) {
                            case "Confirm":
                                Intent intent = new Intent(HomeActivity.this, ConfirmSos.class);
                                startActivity(intent);
                                break;
                            case "Cancel":
                                Intent i = new Intent(HomeActivity.this, CancelSos.class);
                                startActivity(i);
                                break;
                            default:
                                Toast.makeText(HomeActivity.this, "To continue select an Item ",
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }


                });


                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }
        });
        //Intent intent = new Intent(HomeActivity.this,.class);
       // startActivity(intent);
    }

    public void mentors(View v){
        Intent intent = new Intent(HomeActivity.this,MentorsActivity.class);
        startActivity(intent);
    }


    public void profile(View v){
        Intent intent = new Intent(HomeActivity.this,ProfileActivity.class);
        startActivity(intent);
    }

}
