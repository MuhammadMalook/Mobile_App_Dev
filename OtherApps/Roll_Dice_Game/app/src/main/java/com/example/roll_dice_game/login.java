package com.example.roll_dice_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email =findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
    }
    public void Login(View view)
    {
        SharedPreferences pref = getSharedPreferences("myfile",MODE_PRIVATE);
        String em = pref.getString("email","guest");
        String pass = pref.getString("password","null");
        if(email.getText().toString().equals(em) && password.getText().toString().equals(pass))
        {
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "email or password incorrect!", Toast.LENGTH_SHORT).show();
        }

    }
    public void gotoRegister(View view)
    {
        Intent intent = new Intent(this,register.class);
        startActivity(intent);
    }
}