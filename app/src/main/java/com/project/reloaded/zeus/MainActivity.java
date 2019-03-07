package com.project.reloaded.zeus;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private  EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail = (EditText) findViewById(R.id.EEmail);
        editTextPassword = (EditText) findViewById(R.id.Paasword);

        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupPage();

            }
        });

        button = findViewById(R.id.bbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInUser();
            }
        });

    }

    private void SignInUser() {
        String EEmail = editTextEmail.getText().toString().trim();
        String Paassword = editTextPassword.getText().toString().trim();
        if(TextUtils.isEmpty(EEmail)){
            Toast.makeText(this, "please entet the email address",Toast.LENGTH_SHORT).show();

            return;
        }
        if(TextUtils.isEmpty(Paassword)){
            Toast.makeText(this, "please enter the password",Toast.LENGTH_SHORT).show();

            return;
        }

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

        user = firebaseAuth.getCurrentUser();
        assert user != null;
        boolean emailflagger = user.isEmailVerified();
        if (emailflagger){
            Toast.makeText(this, "Authentication successful", Toast.LENGTH_SHORT).show();
            openMainPage();

        }
        else{
            Toast.makeText(this, "User not Verified", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }

    }

}