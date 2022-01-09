package com.example.recievebroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    myBroadCast br = new myBroadCast();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();

        //registering BroadCast
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.Malook");
        registerReceiver(br,filter);
    }
}