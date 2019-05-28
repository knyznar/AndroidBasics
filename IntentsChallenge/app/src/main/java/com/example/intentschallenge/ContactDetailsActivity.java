package com.example.intentschallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ContactDetailsActivity extends AppCompatActivity {
    ImageView ivPhone, ivWebsite, ivLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        ivPhone = findViewById(R.id.ivPhone);
        ivWebsite = findViewById(R.id.ivWebsite);
        ivLocation = findViewById(R.id.ivLocation);

        String name = getIntent().getStringExtra("name");
        final String phone = getIntent().getStringExtra("phone");
        String website = getIntent().getStringExtra("website");
        String location = getIntent().getStringExtra("location");

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });


    }
}
