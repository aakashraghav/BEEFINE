package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    Boolean signupModeActive = true ;
    TextView textView;
    EditText editTextPassword;

    public void moveToHomePage(){
        Intent intent = new Intent(MainActivity.this,homepageActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onKey(View v, int i, KeyEvent event) {
        if (i == KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN) {

            signUp(textView);

        }
        return false;
    }




    public  void signUp(View view ) {
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        if (editTextName.getText().toString()==" "|| editTextPassword.getText().toString()==" "){
            Toast.makeText(this, "A Username and Password are required", Toast.LENGTH_SHORT).show();
        }else {

            if (signupModeActive){
                ParseUser user = new ParseUser();
            user.setUsername(editTextName.getText().toString());
            user.setPassword(editTextPassword.getText().toString());

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Log.i("SignUp", "Successful");
                        moveToHomePage();
                    } else {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else {
                ParseUser.logInInBackground(editTextName.getText().toString(), editTextPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Log.i("SignUp", "successful");
                             moveToHomePage();

                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =(TextView) findViewById(R.id.textView);
        textView.setOnClickListener(this);
        ConstraintLayout costraintLayout=(ConstraintLayout)findViewById(R.id.costraintLayout);
        ImageView logoImageView =(ImageView) findViewById(R.id.logoImageView);;
        TextView beefineTextView= (TextView) findViewById(R.id.beefineTextView);
        costraintLayout.setOnClickListener(this);
        logoImageView.setOnClickListener(this);
         beefineTextView.setOnClickListener(this);

        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextPassword.setOnKeyListener(this);
        if (ParseUser.getCurrentUser() != null){
            moveToHomePage();
        }

        ParseInstallation.getCurrentInstallation().saveInBackground();

    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.textView){
            Button signUpButton =(Button) findViewById(R.id.signUpButton);

            if(signupModeActive){
                signupModeActive =false;
                signUpButton.setText("Login");
                textView.setText("Or SignUp");

            }else{
                signupModeActive =true;
                signUpButton.setText("SignUp");
                textView.setText("Or Login");

            }
        } else if( view.getId() ==R.id.costraintLayout ||view.getId() == R.id.logoImageView || view.getId()==R.id.beefineTextView ) {

            InputMethodManager inputMethodManager =(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }
    }


}