package com.example.mid_2practice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class backGroundService extends Service {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Service started with " +intent.getStringExtra("text") , Toast.LENGTH_SHORT).show();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification builder  = new NotificationCompat.Builder(this,"id")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("My Notificarion")
                .setContentText(intent.getStringExtra("text"))
                .build();

        NotificationChannel channel = new NotificationChannel("id","channer",NotificationManager.IMPORTANCE_DEFAULT);
        manager.createNotificationChannel(channel);

        //manager.notify(1,builder); //when you want to do with background service
        startForeground(1,builder); //starting foreground service.

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
