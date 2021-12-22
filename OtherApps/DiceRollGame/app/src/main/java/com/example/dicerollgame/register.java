package com.example.dicerollgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText name,email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.Rname);
        email = findViewById(R.id.Remail);
        pass = findViewById(R.id.Rpassword);
    }
    public void onRegister(View view)
    {
        SharedPreferences pref = getSharedPreferences("file",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name",name.getText().toString());
        editor.putString("email",email.getText().toString());
        editor.putString("pass", pass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
    }
    public void onForLogin(View view)
    {
        finish();
    }
}