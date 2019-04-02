package com.project.reloaded.zeus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;


public class addMoney extends AppCompatActivity{
    private Button button;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_money);

        databaseReference = FirebaseDatabase.getInstance().getReference("Money_transfers/added_money");
        editText = (EditText) findViewById(R.id.editText3);
        String Amount = editText.getText().toString().trim();
        button = (Button) findViewById(R.id.add_money);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               addtodatabase();
            }
        });
        button = (Button) findViewById(R.id.back_but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addMoney.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

    }
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    public void addtodatabase(){
        String Amount = editText.getText().toString().trim();
        if(TextUtils.isEmpty(Amount)){
            Toast.makeText(this, "Please fill the amount", Toast.LENGTH_SHORT).show();
            return;
        }
        String Id = firebaseUser.getUid();
        String email = firebaseUser.getEmail();
        MoneyDatabase moneyDatabase = new MoneyDatabase(Amount,Id,email);
        databaseReference.child(Id).setValue(moneyDatabase);
        Toast.makeText(this, "current amount added is:"+Amount,Toast.LENGTH_LONG).show();
        openProfilePage();
    }
    public void openProfilePage(){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }

}
