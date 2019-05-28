package com.example.intentschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {
    EditText editTxtPhone, editTxtWebsite, editTxtName, editTxtLocation;
    ImageView smileyFace, mediumFace, sadFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editTxtName = findViewById(R.id.editTxtName);
        editTxtPhone = findViewById(R.id.editTxtPhone);
        editTxtWebsite = findViewById(R.id.editTxtWebsite);
        editTxtLocation = findViewById(R.id.editTxtLocation);
        smileyFace = findViewById(R.id.ivsmiley);
        mediumFace = findViewById(R.id.ivmedium);
        sadFace = findViewById(R.id.ivsad);

        smileyFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTxtName.getText().toString().trim();
                String phone = editTxtPhone.getText().toString().trim();
                String website = editTxtWebsite.getText().toString().trim();
                String location = editTxtLocation.getText().toString().trim();

                if(name.isEmpty() || phone.isEmpty() || website.isEmpty() || location.isEmpty())
                    Toast.makeText(AddContactActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(AddContactActivity.this, com.example.intentschallenge.ContactDetailsActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("phone", phone);
                    intent.putExtra("website", website);
                    intent.putExtra("location", location);

                    startActivity(intent);
                }
            }
        });

    }
}
