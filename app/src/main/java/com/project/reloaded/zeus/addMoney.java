package com.project.reloaded.zeus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class addMoney extends AppCompatActivity{
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_money);
        databaseReference = FirebaseDatabase.getInstance().getReference("transaction");
        editText = (EditText) findViewById(R.id.editText3);
        String Amount = editText.getText().toString().trim();
        button = (Button) findViewById(R.id.add_money);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               addtodatabase();
            }
        });

    }
    DatabaseReference databaseReference;
    public void addtodatabase(){
        String Amount = editText.getText().toString().trim();
        String Id = databaseReference.push().getKey();
        MoneyDatabase moneyDatabase = new MoneyDatabase(Amount,Id);
        if (Id != null) {
            databaseReference.child(Id).setValue(moneyDatabase);
        }
    }

}
