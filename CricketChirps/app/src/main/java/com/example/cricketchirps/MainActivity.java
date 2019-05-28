package com.example.cricketchirps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtViewDescription, txtViewResults;
    EditText editTxtGetChirps;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtViewDescription = findViewById(R.id.txtVdescription);
        txtViewResults = findViewById(R.id.txtVresults);
        editTxtGetChirps = findViewById(R.id.edGetChirps);
        submitButton = findViewById(R.id.btnSubmit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = editTxtGetChirps.getText().toString().trim();
                if(!temp.isEmpty()) {
                    int temperature = Integer.parseInt(temp);
                    temperature = temperature / 3 + 4;
                    txtViewResults.setText("Current temperature is " + temperature + "°C");
                }else txtViewResults.setText("no input");
            }
        });
    }
}
