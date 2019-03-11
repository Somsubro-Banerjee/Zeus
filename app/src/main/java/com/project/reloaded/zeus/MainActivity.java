package com.project.reloaded.zeus;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private FirebaseAuth firebaseAuth;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );//for running the activities in fullscreen mode
        editTextEmail = (EditText) findViewById(R.id.EEmail);
        editTextPassword = (EditText) findViewById(R.id.Paasword);

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
                SignInUser();
            }
        });

    }

    private void SignInUser() {
        String EEmail = editTextEmail.getText().toString().trim();
        String Paassword = editTextPassword.getText().toString().trim();
        if(TextUtils.isEmpty(EEmail)){
            Toast.makeText(this, "please enter the email address",Toast.LENGTH_SHORT).show();

            return;
        }
        if(TextUtils.isEmpty(Paassword)){
            Toast.makeText(this, "please enter the password",Toast.LENGTH_SHORT).show();

            return;
        }
        if(Paassword.length()<=6){
            Toast.makeText(this,"Password Too Short, enter minimum 6 characters",Toast.LENGTH_LONG).show();
        }
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(EEmail,Paassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    updateUI(user);                }
                else {
                    Toast.makeText(MainActivity.this,"User not Verified or Email-ID/Password Incorrect",Toast.LENGTH_LONG).show();
                    firebaseAuth.signOut();
                }
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



    private void updateUI(FirebaseUser user) {
        if (user != null) {
           user.isEmailVerified();
           user.getUid();
           Toast.makeText(this,"Email Verified Successfully",Toast.LENGTH_LONG).show();
           openMainPage();
        }

    }
}


