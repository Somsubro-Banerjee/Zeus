package com.project.reloaded.zeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    private Button button;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupPage();

            }
        });


        button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailVerification();
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

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            boolean emailVerified = user.isEmailVerified();
            if(emailVerified){
                openMainPage();
            }
            else
            {
                Toast.makeText(this, "Please verify your email id ", Toast.LENGTH_SHORT).show();
            }
        }


    }

}
