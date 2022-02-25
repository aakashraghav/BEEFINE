package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddictionSelfAssessment1 extends AppCompatActivity {
    Button AddictionAssessment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addiction_self_assessment1);

      AddictionAssessment2=(Button) findViewById(R.id.buttonAddictionBeginTest1);
      AddictionAssessment2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent addictionintent = new Intent(getApplicationContext(),AddictionSelfAssessment2.class);
              startActivity(addictionintent);




          }
      });
    }


}