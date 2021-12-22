package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    EditText name;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        name = findViewById(R.id.fullname);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
    }
    public void Register(View view)
    {
        SharedPreferences pref = getSharedPreferences("mypref",MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();
        if(name.getText().toString().equals("") || email.getText().toString().equals("") || password.getText().toString().equals(""))
        {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
        }
        else {
            editor.putString("name", name.getText().toString());
            editor.putString("email", email.getText().toString());
            editor.putString("password", password.getText().toString());

            editor.commit();
            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
        }
    }
    public  void gotoLogin(View view)
    {
        finish();
    }
}