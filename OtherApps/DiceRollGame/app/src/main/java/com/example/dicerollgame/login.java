package com.example.dicerollgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
    }
    public void onLogin(View view)
    {
        SharedPreferences pref = getSharedPreferences("file",MODE_PRIVATE);
        String em = pref.getString("email","guest");
        String password = pref.getString("pass","null");

        if(em.equals(email.getText().toString()) && password.equals(pass.getText().toString()))
        {
            Toast.makeText(this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
    public void onForRegister(View view)
    {
        Intent intent = new Intent(this,register.class);
        startActivity(intent);

    }
}