package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class AddictionSelfAssessment2 extends AppCompatActivity {
    List<QuestionsAddiction> quesList;
    int qid = 1;
    QuestionsAddiction currentQ;
    TextView txtQuestion;
    RadioButton rda ,rdb;
    Button addictionNextQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addiction_self_assessment2);


        DbHelper db = new DbHelper(this);
        quesList=db.getAllQuestions();
        txtQuestion=(TextView) findViewById(R.id.addictionQ1) ;
        rda=(RadioButton) findViewById(R.id.radio1_1) ;
        rdb=(RadioButton) findViewById(R.id.radio1_2) ;
        addictionNextQuestion=(Button) findViewById(R.id.addictionNextQuestion);
        currentQ =quesList.get(qid);
        setQuestionView();
        addictionNextQuestion.setOnClickListener((v -> {
            RadioGroup grp= (RadioGroup) findViewById(R.id.addictionRadioGroup1);
            RadioButton answer=(RadioButton) findViewById(grp.getCheckedRadioButtonId());
            grp.clearCheck();
            if(qid<22){
                currentQ =quesList.get(qid);
                setQuestionView();
            }else{
                Intent addictionresults  = new Intent (AddictionSelfAssessment2.this,AddictionResult.class) ;
                startActivity(addictionresults);
                finish();
            }

        }));

    }

   private void setQuestionView(){
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rda.setText(currentQ.getOPTB());
        qid++;
   }




}