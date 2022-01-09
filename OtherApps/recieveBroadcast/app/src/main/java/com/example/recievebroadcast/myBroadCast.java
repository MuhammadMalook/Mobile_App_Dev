package com.example.recievebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class myBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("com.example.Malook"))
                Toast.makeText(context, "BroadCast Started "+intent.getStringExtra("name"), Toast.LENGTH_SHORT).show();
    }
}
