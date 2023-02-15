package com.example.sharedpreferencegfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class TutorialsPointActivity extends AppCompatActivity {

    TextInputEditText nameTxt,ageTxt,emailTxt;
    Button saveBtn,loadBtn;

    private static final String MY_PREFERENCE = "myPref";
    private static final String NAME = "nameKey";
    private static final String AGE = "ageKey";
    private static final String EMAIL = "emailKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials_point);

        nameTxt = (TextInputEditText) findViewById(R.id.name_edit_txt);
        ageTxt = (TextInputEditText) findViewById(R.id.age_edit_txt);
        emailTxt = (TextInputEditText) findViewById(R.id.email_edit_txt);

        saveBtn = (Button) findViewById(R.id.save_btn);
        loadBtn = (Button) findViewById(R.id.load_btn);

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFERENCE,MODE_PRIVATE);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameTxt.getText().toString();
                String age = ageTxt.getText().toString();
                String email = emailTxt.getText().toString();

                SharedPreferences.Editor shEditor = sharedPreferences.edit();

                shEditor.putString(NAME,name);
                shEditor.putString(AGE,age);
                shEditor.putString(EMAIL,email);
                shEditor.commit();

                Toast.makeText(TutorialsPointActivity.this, "Values Saved", Toast.LENGTH_SHORT).show();
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameTxt.setText(sharedPreferences.getString(NAME,""));
                ageTxt.setText(sharedPreferences.getString(AGE,""));
                emailTxt.setText(sharedPreferences.getString(EMAIL,""));
            }
        });
    }
}