package com.example.crudopdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText name,phone,street,email,city;
    String fileName = "students.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.Name);
        phone = findViewById(R.id.Phone);
        street = findViewById(R.id.Street);
        email = findViewById(R.id.Email);
        city = findViewById(R.id.City);

    }
    public void insert(View view) throws IOException {
        if(name.getText().toString().equals("") || phone.getText().toString().equals("") || street.getText().toString().equals("") || email.getText().toString().equals("") || city.getText().toString().equals(""))
        {
            Toast.makeText(this,"Please fill all fields",Toast.LENGTH_SHORT).show();
        }
        else {
            FileOutputStream outputStream = openFileOutput(fileName, MODE_APPEND);
            outputStream.write(name.getText().toString().getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(phone.getText().toString().getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(street.getText().toString().getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(email.getText().toString().getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(city.getText().toString().getBytes());
            outputStream.write("\n".getBytes());
            Toast.makeText(this, "Record inserted", Toast.LENGTH_SHORT).show();
        }
    }

    public void Show(View view)
    {
        Intent intent = new Intent(this,ShowAll.class);
        startActivity(intent);
    }
    public void delete(View view)
    {
        Intent intent = new Intent(this,delete.class);
        startActivity(intent);
    }
    public void update(View view)
    {
        Intent intent = new Intent(this,update.class);
        startActivity(intent);
    }

}