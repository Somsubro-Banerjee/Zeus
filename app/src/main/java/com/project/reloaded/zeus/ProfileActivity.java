package com.project.reloaded.zeus;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.provider.ContactsContract;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.jar.Attributes;


public class ProfileActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private Button button;
    private EditText editText1, editText2, editText3, editText4;
    private FirebaseAuth firebaseAuth;
    private FloatingActionButton floatingActionButton;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );//for running the activities in fullscreen mode

        editText1 = (EditText) findViewById(R.id.editText4);
        editText2 = (EditText) findViewById(R.id.name);
        editText3 = (EditText) findViewById(R.id.emailll);
        editText4 = (EditText) findViewById(R.id.phone);


        databaseReference = FirebaseDatabase.getInstance().getReference("transaction");

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


    }

    public void pay(){//see  i said still not implemented......this is the only task now  LOL\

        String amount = editText1.getText().toString().trim();
        String name = editText2.getText().toString().trim();
        String email = editText3.getText().toString().trim();
        String phone = editText4.getText().toString().trim();



        if(TextUtils.isEmpty(amount)){
            Toast.makeText(this, "Please enter a amount to send", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "Enter the name of the person", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter  the email id of the person", Toast.LENGTH_SHORT).show();
            return;
        }
        if ((TextUtils.isEmpty(phone))){
            Toast.makeText(this, "Please enter the phone number of the person", Toast.LENGTH_SHORT).show();
            return;
        }

        openSuccessfulPage();

        addToDatabase();

        sendEmail();

    }

    public  void openSuccessfulPage(){
        Intent intent = new Intent(this,Successful.class);
        startActivity(intent);
    }
    public void openMoreOptions(){
        Intent intent = new Intent(this, More.class);
        startActivity(intent);
    }

    public void addToDatabase(){

        String amount = editText1.getText().toString().trim();
        String name = editText2.getText().toString().trim();
        String email = editText3.getText().toString().trim();
        String phone = editText4.getText().toString().trim();

        String id = databaseReference.push().getKey();

        Database database = new Database(id,name,email,phone,amount);
        databaseReference.child(name).setValue(database);
    }

    protected void sendEmail() {


        String email = editText3.getText().toString().trim();
        String amount = editText1.getText().toString().trim();


        Log.i("Send email", "");

        String[] TO = {email};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Regarding recent transaction done");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello\t"+email+"\ti have paid you a amount of \t"+amount+"\tto your Zeus Wallet.......Thank You!!!" );

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ProfileActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }



}
