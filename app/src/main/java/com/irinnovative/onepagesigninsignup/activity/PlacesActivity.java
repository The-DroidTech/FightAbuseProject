package com.irinnovative.onepagesigninsignup.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.pojo.Place;


public class PlacesActivity extends AppCompatActivity {

    private ImageSwitcher imageSwitcher;
    private Button btnNext;
    private Toolbar toolbar;
    private RatingBar rateBar;
    private TextView txtRatingl, txtDescription,txtInfo;
    private LinearLayout layout;
    private ImageButton btnAddress,btnTelephone,btnWebsite,btnDirections;

    int currentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.hotel_image_switch);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnNext = (Button) findViewById(R.id.buttonNext);
        txtDescription = (TextView) findViewById(R.id.txt_hotel_desc);
        layout = (LinearLayout) findViewById(R.id.linearDetails);
        btnAddress = (ImageButton) findViewById(R.id.btn_place);
        btnTelephone = (ImageButton) findViewById(R.id.btn_call);
        btnWebsite = (ImageButton) findViewById(R.id.btn_web);
        txtInfo = (TextView) findViewById(R.id.hotel_info);
        btnDirections =(ImageButton) findViewById(R.id.btn_direction);


        Intent intent = getIntent();
        final Place place = (Place) intent.getSerializableExtra("places");

        toolbar.setTitle(place.getName());
        txtDescription.setText(place.getDesc());
        final int[] imageIds = place.getImageURl();
        final int count = imageIds.length;

       imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));


                return imageView;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if(currentIndex == count){
                    currentIndex = 0;
                }
                imageSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });

        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);
                txtInfo.setText(place.getAddress());

                txtInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }


        });


        btnTelephone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);
                txtInfo.setText(place.getTelephone());

                txtInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:"+ place.getTelephone()));
                        startActivity(intent);
                    }
                });
            }
        });


        btnWebsite.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);
                txtInfo.setText(place.getWebsite());

                txtInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+place.getWebsite()));
                        Intent browserChooserIntent = Intent.createChooser(browserIntent , "Choose browser of your choice");
                        startActivity(browserChooserIntent );
                    }
                });


            }
        });

        btnDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + place.getAddress() +" "+ place.getName());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        imageSwitcher.setImageResource(imageIds[0]);

        //Animation
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);


    }
}
