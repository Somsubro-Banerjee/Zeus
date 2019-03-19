package com.project.reloaded.zeus;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );//for running the activities in fullscreen mode
        ConstraintLayout constraintLayout = findViewById(R.id.layout1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        final String email =getIntent().getStringExtra("email");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(email);
        button =findViewById(R.id.buttoonn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileAcivity(email);
            }
        });



    }

    public void openProfileAcivity(String email){
        Intent intent = new Intent(this,ProfileActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }


}
