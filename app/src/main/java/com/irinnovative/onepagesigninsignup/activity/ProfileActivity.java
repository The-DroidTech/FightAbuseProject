package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Person;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.R.attr.data;
import static android.R.attr.value;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseUser user;
    private ImageView imProfilePic;
    private TextView textViewUsername,textViewBio,textViewCellphone,textViewEmail;
    int RESULT_LOAD_IMG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("PROFILE");

        textViewUsername = (TextView) findViewById(R.id.textView_profile_username);
        textViewBio = (TextView) findViewById(R.id.textView_profile_bio);
        textViewCellphone = (TextView) findViewById(R.id.textView_profile_cellphone);
        textViewEmail = (TextView) findViewById(R.id.textView_profile_email);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Profile");

        user = FirebaseAuth.getInstance().getCurrentUser();

        imProfilePic = (ImageView) findViewById(R.id.ImageView_user_pic);


        textViewEmail.setText(user.getEmail());
        try {
            Uri imageUri = user.getPhotoUrl();
            if (imageUri != null) {
                InputStream imageStream = getContentResolver().openInputStream(imageUri);
                Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imProfilePic.setImageBitmap(selectedImage);
            } else {
                imProfilePic.setImageResource(R.drawable.blank);
            }

        } catch (FileNotFoundException e) {

        }


        imProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
            }
        });


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Person value = dataSnapshot.getValue(Person.class);
                textViewUsername.setText(value.getUsername());
                textViewBio.setText(value.getBio());
                textViewCellphone.setText(value.getCellphone());

                Log.d("TAG", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imProfilePic.setImageBitmap(selectedImage);

                UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                        .setPhotoUri(imageUri).build();

                user.updateProfile(profileChangeRequest)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d("TAG", "User profile updated.");
                                    Toast.makeText(getBaseContext(), "Successful", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(ProfileActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(ProfileActivity.this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_update, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.log_out) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, MainActivity.class));
            return true;
        } else if (id == R.id.updatSos) {
            startActivity(new Intent(this, SosDetailsActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }

}
