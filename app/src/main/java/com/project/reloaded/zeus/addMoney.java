package com.project.reloaded.zeus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addMoney extends AppCompatActivity{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_money);
        EditText editText = (EditText) findViewById(R.id.editText3);
        final String Amount = editText.getText().toString().trim();
        button = (Button) findViewById(R.id.add_money);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent1= new Intent(addMoney.this,ProfileActivity.class);
                intent1.putExtra("money", Amount);
                startActivity(intent1);
            }
        });
    }
}
