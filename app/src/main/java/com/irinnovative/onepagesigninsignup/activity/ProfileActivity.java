package com.irinnovative.onepagesigninsignup.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Person;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseUser user;
    private StorageReference mStorageRef;
    private DatabaseReference myRef,uploadRef;

    private ImageView imProfilePic;
    private TextView textViewUsername, textViewBio, textViewCellphone, textViewEmail;
    int RESULT_LOAD_IMG = 1;
    private Person value;

    private Uri imageUri, downloadUri;
    ProgressDialog pd;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_update);
       //getSupportActionBar().setTitle("PROFILE");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewUsername = (TextView) findViewById(R.id.textView_profile_username);
        textViewBio = (TextView) findViewById(R.id.textView_profile_bio);
        textViewCellphone = (TextView) findViewById(R.id.textView_profile_cellphone);
        textViewEmail = (TextView) findViewById(R.id.textView_profile_email);

        pd = new ProgressDialog(this);
        pd.setMessage("Uploading....");

        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        mStorageRef = FirebaseStorage.getInstance().getReference().child(uid);
        myRef = database.getReference().child("Profile").child(uid);
        uploadRef = database.getReference().child("Profile").child(uid).child("imageUrl");


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


    }

    @Override
    protected void onStart() {
        super.onStart();
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                value = dataSnapshot.getValue(Person.class);
                if (value != null) {
                    getSupportActionBar().setTitle(value.getUsername());
                    //setTitle(value.getUsername());
                    textViewBio.setText(value.getBio());
                    textViewCellphone.setText(value.getCellphone());

                    Glide.with(getApplicationContext()).load(value.getImageUrl()).into(imProfilePic);

                }


                //Log.d("TAG", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

       // mStorageRef.ad

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                imageUri = data.getData();
                pd.show();

                //uploading the image
                UploadTask uploadTask = mStorageRef.child(uid).putFile(imageUri);

                uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        value.setImageUrl(downloadUrl.toString());
                        myRef.setValue(value);
                        pd.dismiss();

                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                .setPhotoUri(downloadUrl)
                                .build();

                        if ( user != null ) {
                            user.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Log.d("Profile Updated ", "User profile updated.");
                                            }
                                        }
                                    });
                        }

                        Toast.makeText(ProfileActivity.this, "Upload successful", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(ProfileActivity.this, "Upload Failed -> " + e, Toast.LENGTH_SHORT).show();
                    }
                });
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imProfilePic.setImageBitmap(selectedImage);


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
        if (id == R.id.updatSos) {
            startActivity(new Intent(this, SosDetailsActivity.class));
        }if(id == android.R.id.home)
        {
            onBackPressed();
        }


        return super.onOptionsItemSelected(item);
    }

}
