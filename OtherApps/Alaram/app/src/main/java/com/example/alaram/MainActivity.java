package com.example.alaram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = findViewById(R.id.editTextTextPersonName);

    }
    public void createAlaram(View view)
    {
        int timeSec = Integer.parseInt(time.getText().toString());
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent myReciverintent = new Intent(this,MyReciever.class);
        PendingIntent intent = PendingIntent.getBroadcast(this, 1234, myReciverintent, 0);
        manager.set(AlarmManager.RTC_WAKEUP,timeSec*1000,intent);
    }

}