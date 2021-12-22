package com.example.sqllite_db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText name,username,password;
    DBhelper dBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.fullname);
        username = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
    }
    public void register(View view)
    {
        dBhelper.insertLogin(name.getText().toString(),username.getText().toString(),password.getText().toString());
        Toast.makeText(this, "User Reistered Succesfully!", Toast.LENGTH_SHORT).show();
    }

    public  void gotoLogin(View view)
    {
        finish();
    }
}