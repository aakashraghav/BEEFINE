package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.parse.ParseUser;

import java.util.ArrayList;


public class homepageActivity extends AppCompatActivity {
    //initialize variable
    RecyclerView recyclerView;

    ArrayList<MainModel> mainModels;

    MainAdapter mainAdapter;

    //auto recycler view

    RecyclerView autorRecyclerView;

    MainAdapter AutoScrollAdapter;

     // array list <mainmodel> autorvmodel

     ArrayList<MainModel> autoRVModel;


    public void  openReadMoreActivity(){
        Intent i = new Intent (this , ReadMoreActivity.class );
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater= getMenuInflater();

        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (item.getItemId()==R.id.Logout){
            ParseUser.logOut();
            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);


        }
        else if (item.getItemId()==R.id.selfAssesment){
            Intent selfAssesmentIntent = new Intent(getApplicationContext(),selfAssesmentActivity.class);
            startActivity(selfAssesmentIntent);
        }

        return super.onOptionsItemSelected(item);
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homepage);
       final   Button button= (Button) findViewById(R.id.button_ReadMore);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReadMoreActivity();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BEEFINE");

        autorRecyclerView = findViewById(R.id.auto_Recycler_View);


        //assign variable
        recyclerView = findViewById(R.id.recyclerView);

        // create integer array
        Integer[] langLogo = {R.drawable.addiction,R.drawable.anger,R.drawable.anxiety,R.drawable.chronicpain,R.drawable.depression,R.drawable.griefandloss,R.drawable.ocd,R.drawable.phobia,R.drawable.stress};

        //create string array
        String[] langName = {"Addiction","Anger","Anxiety","ChronicPain","Depression","Grief and Loss","OCD","Fear and Phobia","Stress"};

        //initialize Arraylist
        mainModels= new ArrayList<>();
        for(int i =0;i<langLogo.length;i++){
            MainModel model = new MainModel(langLogo[i],langName[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // initialize mainadapter
        mainAdapter = new MainAdapter(this,mainModels);
        //set mainadapter
        recyclerView.setAdapter(mainAdapter);

        //initialize Autoscroll adpater
        AutoScrollAdapter = new MainAdapter(this,autoRVModel);
        setTitle("BEEFINE");
    }


}