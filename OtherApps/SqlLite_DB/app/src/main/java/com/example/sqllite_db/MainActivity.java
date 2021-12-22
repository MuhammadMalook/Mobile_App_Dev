package com.example.sqllite_db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DBhelper dBhelper;
    EditText username,passwword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.loginEmail);
        passwword = findViewById(R.id.loginPassword);
    }
    public void Login(View view)
    {
       Boolean flag = dBhelper.LoginUser(username.getText().toString(),passwword.getText().toString());
    }
}