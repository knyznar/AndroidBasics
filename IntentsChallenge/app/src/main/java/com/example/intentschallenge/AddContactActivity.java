package com.example.intentschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTxtPhone, editTxtWebsite, editTxtName, editTxtLocation;
    ImageView smileyFace, mediumFace, sadFace;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editTxtName = findViewById(R.id.editTxtName);
        editTxtPhone = findViewById(R.id.editTxtPhone);
        editTxtWebsite = findViewById(R.id.editTxtWebsite);
        editTxtLocation = findViewById(R.id.editTxtLocation);
        smileyFace = findViewById(R.id.ivsmiley);
        mediumFace = findViewById(R.id.ivmedium);
        sadFace = findViewById(R.id.ivsad);

        smileyFace.setOnClickListener(this);
        sadFace.setOnClickListener(this);
        mediumFace.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(editTxtName.getText().toString().trim().isEmpty() || editTxtPhone.getText().toString().trim().isEmpty()
                || editTxtWebsite.getText().toString().trim().isEmpty() || editTxtLocation.getText().toString().trim().isEmpty())
            Toast.makeText(AddContactActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent();
            intent.putExtra("name", editTxtName.getText().toString().trim());
            intent.putExtra("phone", editTxtPhone.getText().toString().trim());
            intent.putExtra("website", editTxtWebsite.getText().toString().trim());
            intent.putExtra("location", editTxtLocation.getText().toString().trim());

            if(v.getId() == R.id.ivsmiley) {
                intent.putExtra("mood", "happy");
            } else if(v.getId() == R.id.ivmedium) {
                intent.putExtra("mood", "medium");
            }else if(v.getId() == R.id.ivsad) {
                intent.putExtra("mood", "sad");
            }

            setResult(RESULT_OK, intent);
            AddContactActivity.this.finish();
        }
    }
}
