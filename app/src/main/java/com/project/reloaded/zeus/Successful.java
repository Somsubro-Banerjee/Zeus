package com.project.reloaded.zeus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Successful extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.successfull);
        button = (Button) findViewById(R.id.GoBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               GoBack();
            }
        });
    }


    public void GoBack() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}