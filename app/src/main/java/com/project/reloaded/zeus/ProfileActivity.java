package com.project.reloaded.zeus;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.nfc.NfcAdapter;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileActivity extends AppCompatActivity {

    NfcAdapter nfcAdapter;
    private Button button;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );//for running the activities in fullscreen mode
        button=findViewById(R.id.button6);
        ConstraintLayout constraintLayout = findViewById(R.id.layout2);//this is just the animation part of the program which changes the colors in background
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        nfcAdapter = NfcAdapter.getDefaultAdapter(this);//t well this still is still not implemented......
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay();
            }
        });

        button=findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();

            }
        });


    }
    public void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void pay(){//see  i said still not implemented

    }
}
