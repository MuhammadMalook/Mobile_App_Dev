package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void generateBroadCast(View view)
    {
        //sending Broadcast
        Intent intent = new Intent();
        intent.setAction("com.example.Malook");
        intent.putExtra("name","Malook");
        sendBroadcast(intent);
    }
}