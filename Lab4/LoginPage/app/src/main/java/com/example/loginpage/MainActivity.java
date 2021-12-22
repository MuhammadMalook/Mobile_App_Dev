package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email =findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        SharedPreferences pref = getSharedPreferences("loginFile",MODE_PRIVATE);
        if(pref.getString("login","No").equals("Yes"))
        {
            Intent intent = new Intent(this,welcome.class);
            startActivity(intent);
        }
    }
    public void Login(View view)
    {
        SharedPreferences pref = getSharedPreferences("mypref",MODE_PRIVATE);
        SharedPreferences login = getSharedPreferences("loginFile",MODE_PRIVATE);
        SharedPreferences.Editor eLogin= login.edit();
        String em = pref.getString("email","guest");
        String pass = pref.getString("password","null");
        if(email.getText().toString().equals(em) && password.getText().toString().equals(pass))
        {
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            eLogin.putString("login","Yes");
            eLogin.commit();
            Intent intent = new Intent(this,welcome.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "email or password incorrect!", Toast.LENGTH_SHORT).show();
        }

    }
    public void gotoRegister(View view)
    {
        Intent intent = new Intent(this,RegisterPage.class);
        startActivity(intent);
    }

}
