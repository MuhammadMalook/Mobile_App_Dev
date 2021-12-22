package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView);
    }
    public void newThread(View view)
    {
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                x+=10;
//            }
//
//        });
//        t.start();
//        //it will execute before run method , so at first click it will give x=0 then x=10 but actually x will be having 20 after the button click
//        txt.setText("value of x is "+x);
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                x+=10;
//                txt.setText("value of x is "+x);//Exception : Only the original thread that created a view hierarchy can touch its views.
//                //this thread can not access the ui components. only main thread can
//            }
//
//        });
//        t.start();
        //it will execute before run method , so at first click it will give x=0 then x=10 but actually x will be having 20 after the button click

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                x+=10;
//                txt.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        txt.setText("value of x is "+x); //it will work fine and will return actual value of x.
//                    }
//                });
//            }
//
//        });
//        t.start();


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                    x+=10;
                    txt.setText("value of x is "+x);
            }
        });
   }
}