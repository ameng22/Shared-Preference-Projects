package com.example.sharedpreferencegfg;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText name_txt;
    TextInputEditText age_txt;
    Button next_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_txt = (TextInputEditText) findViewById(R.id.name_edit_txt);
        age_txt = (TextInputEditText) findViewById(R.id.age_edit_txt);
        next_btn = (Button) findViewById(R.id.go_to_btn);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),TutorialsPointActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("mySharedPref",MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        int age = sharedPreferences.getInt("age",0);

        name_txt.setText(name);
        age_txt.setText(String.valueOf(age));
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("mySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor shEditor = sharedPreferences.edit();

        shEditor.putString("name",name_txt.getText().toString());
        shEditor.putInt("age",Integer.parseInt(age_txt.getText().toString()));
        shEditor.apply();
    }
}