package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReadMoreActivity extends AppCompatActivity {


    TextView StressDetail;
    LinearLayout layout;
    TextView AnxietyDetail;
    LinearLayout layout1;
    TextView AngerDetail;
    LinearLayout layout2;
    TextView OCDDetail;
    LinearLayout layout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_more);

      //stress card view
        StressDetail= findViewById(R.id.StressDetails);

        layout = findViewById(R.id.layout);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        //anxiety card view
        AnxietyDetail = findViewById(R.id.AnxietyDetails);
        layout1 = findViewById(R.id.layout1);
        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        //anger card view
        AngerDetail = findViewById(R.id.AngerDetails);
        layout2= findViewById(R.id.layout2);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        //Ocd card view
        OCDDetail = findViewById(R.id.OCDDetails);
        layout3= findViewById(R.id.layout3);
        layout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);


    }


    public void expand(View view) {
        int v =(StressDetail.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;

        TransitionManager.beginDelayedTransition(layout,new AutoTransition());
        StressDetail.setVisibility(v);



    }
    public void expand1(View view) {
        int v1 = (AnxietyDetail.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout1, new AutoTransition());
        AnxietyDetail.setVisibility(v1);
    }
    public void expand2(View view) {
        int v2 = (AngerDetail.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout2, new AutoTransition());
        AngerDetail.setVisibility(v2);
    }
    public void expand3(View view) {
        int v3 = (OCDDetail.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout3, new AutoTransition());
        OCDDetail.setVisibility(v3);
    }

}