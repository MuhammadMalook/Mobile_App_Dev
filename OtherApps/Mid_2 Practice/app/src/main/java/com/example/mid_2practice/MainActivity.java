package com.example.mid_2practice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         text = findViewById(R.id.editTextTextPersonName);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startService(View view)
    {
        Intent intent = new Intent(this, backGroundService.class);
        intent.putExtra("text",text.getText().toString());

        //startService(intent);  //background service
        startForegroundService(intent); //foreground service
    }

}