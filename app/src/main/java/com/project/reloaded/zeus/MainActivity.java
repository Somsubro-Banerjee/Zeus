package com.project.reloaded.zeus;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.bbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailVerification();
            }
        });


        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupPage();

            }
        });

    }
    public void openSignupPage(){
        Intent intent  = new Intent(this, SignupPage.class);
        startActivity(intent);
    }
    public void openMainPage(){
        Intent intent = new Intent(this,MainPage.class);
        startActivity(intent);
    }


    public void checkEmailVerification(){
        user = FirebaseAuth.getInstance().getCurrentUser();
        Boolean emailflagger = null;
        if (user != null) {
            emailflagger = user.isEmailVerified();
        }
        openMainPage();

        if (!emailflagger) {
            Toast.makeText(this, "User not Verified", Toast.LENGTH_SHORT).show();
            //firebaseAuth.signOut();

        } else {
            Toast.makeText(this, "Authentication successful", Toast.LENGTH_SHORT).show();
            openMainPage();

        }

    }
}
