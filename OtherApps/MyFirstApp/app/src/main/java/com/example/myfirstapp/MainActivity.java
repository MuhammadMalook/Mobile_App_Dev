package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView txt = findViewById(R.id.myText);
//        txt.setText("Hello IBA Sukkur");
        ImageView img = findViewById(R.id.imageView);
        img.setImageResource(R.drawable.logo);
    }
    public void check(View view)
    {
        CheckBox cb = findViewById(R.id.checkBox);
        TextView txt = findViewById(R.id.mytext);
        if(cb.isChecked())
        {
            txt.setText("Checked");
        }
        else
            txt.setText("Unchecked");
    }

}