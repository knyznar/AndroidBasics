package com.example.intentschallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAddContact;
    ImageView ivPhone, ivWebsite, ivLocation, ivMood;
    String name="", phone="", location="", website="", mood="";
    final int CREATE_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddContact = findViewById(R.id.btnAddContact);
        ivPhone = findViewById(R.id.ivphone);
        ivWebsite = findViewById(R.id.ivwebsite);
        ivLocation = findViewById(R.id.ivlocation);
        ivMood = findViewById(R.id.ivmood);

        ivMood.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);
        ivWebsite.setVisibility(View.GONE);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.intentschallenge.AddContactActivity.class);
                startActivityForResult(intent, CREATE_CONTACT);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });

        ivWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + website));
                startActivity(intent);
            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CREATE_CONTACT) {
            if(resultCode == RESULT_OK) {
                ivMood.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivLocation.setVisibility(View.VISIBLE);
                ivWebsite.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                phone = data.getStringExtra("phone");
                website = data.getStringExtra("website");
                location = data.getStringExtra("location");
                mood = data.getStringExtra("mood");

                if(mood.equals("happy")) {
                    ivMood.setImageResource(R.drawable.smiley_face);
                } else if(mood.equals("medium")) {
                    ivMood.setImageResource(R.drawable.medium_face);
                } else if(mood.equals("sad")) {
                    ivMood.setImageResource(R.drawable.sad_face);
                }
            } else {
                Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
