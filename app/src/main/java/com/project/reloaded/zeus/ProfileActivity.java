package com.project.reloaded.zeus;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.nfc.NfcAdapter;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.text.TextUtils;
import android.view.View;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;


public class ProfileActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private Button button;
    private EditText editText;
    private FirebaseAuth firebaseAuth;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );//for running the activities in fullscreen mode

        editText = (EditText) findViewById(R.id.editText4);
        editText =(EditText) findViewById(R.id.name);
        editText = (EditText) findViewById(R.id.emailll);
        editText = (EditText) findViewById(R.id.phone);

        imageButton = (ImageButton) findViewById(R.id.more);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMoreOptions();
            }
        });

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay();
            }
        });
        if(editText==null){
            Toast.makeText(this, "Enter the Details above....", Toast.LENGTH_SHORT).show();
        }


    }

    public void pay(){//see  i said still not implemented......this is the only task now  LOL
        String amount = editText.getText().toString().trim();
        openSuccessfulPage();
    }

    public  void openSuccessfulPage(){
        Intent intent = new Intent(this,Successful.class);
        startActivity(intent);
    }
    public void openMoreOptions(){
        Intent intent = new Intent(this, More.class);
        startActivity(intent);
    }

}
