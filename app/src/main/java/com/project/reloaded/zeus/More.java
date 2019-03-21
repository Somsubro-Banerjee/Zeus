package com.project.reloaded.zeus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class More extends AppCompatActivity {
    private Button button;
    private ImageButton imageButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more);
        FirebaseUser firebaseUser;
        FirebaseAuth firebaeAuth;

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser!=null){
            String email = firebaseUser.getEmail();
            String UID = firebaseUser.getUid();
            TextView textView = (TextView) findViewById(R.id.textView22) ;
            textView.setText(email);
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//for running the activities in fullscreen mode
        button = (Button) findViewById(R.id.about_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutPage();
            }
        });

        button = (Button) findViewById(R.id.logout_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });
    }
    public void openAboutPage(){
        Intent intent = new Intent(this, AboutPage.class);
        startActivity(intent);
    }
    public void openLoginPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}