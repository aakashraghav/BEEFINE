package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selfAssesmentActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView anxiety,anger,addiction,chronicPain,depression;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assesment);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("SELF ASSESSMENT");

        anxiety=(CardView) findViewById(R.id.Anxiety);
        anger=(CardView) findViewById(R.id.Anger);
        addiction=(CardView) findViewById(R.id.Addiction);
        chronicPain=(CardView) findViewById(R.id.ChronicPain);
       depression=(CardView) findViewById(R.id.Depression);
        anxiety.setOnClickListener(this);
       anger.setOnClickListener(this);
        addiction.setOnClickListener(this);
        chronicPain.setOnClickListener(this);
        depression.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent i1;

        switch (v.getId()){
            case R.id.Anxiety:
                i1= new Intent(this ,AnxietySelfAssessment1.class);
                startActivity(i1);
                break;

            case R.id.Anger:
                i1 = new Intent(this ,AngerSelfAssessment1.class);
                startActivity(i1);
                break;

            case R.id.Addiction:
                i1 = new Intent(this ,AddictionSelfAssessment1.class);
                startActivity(i1);
                break;

            case R.id.ChronicPain:
                i1 = new Intent(this ,ChronicPainSelfAssessment1.class);
                startActivity(i1);
                break;

            case R.id.Depression:
                i1 = new Intent(this ,DepressionSelfAssessment1.class);
                startActivity(i1);
                break;
        }



    }
}