package com.example.tmnt_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView img = findViewById(R.id.imageView);
                TextView txt = findViewById(R.id.textView);
                if(position == 0)
                {
                    img.setImageResource(R.drawable.jennika);
                    txt.setText("Jennika is a young female assassin from the Foot. She was arrested at a young age for robbery after running away from home and befriended a Foot ninja in prison. After she escaped, she swore loyalty to the Foot");

                }
                else if(position == 1)
                {
                    img.setImageResource(R.drawable.raphael);
                    txt.setText("Raphael is the fiery, violent bad boy of the Ninja Turtles and the second-oldest brother. Raph wears a red mask and wields a pair of sais.");
                }
                else if(position == 2)
                {
                    img.setImageResource(R.drawable.donatello);
                    txt.setText("Donatello is the scientist, inventor, engineer, and technological genius of the Ninja Turtles and the second-youngest/middle-child brother. Donnie wears a purple mask and wields a bo-staff.");
                }
                else if(position == 3)
                {
                    img.setImageResource(R.drawable.leonardo);
                    txt.setText("Leonardo is the brave leader of the Ninja Turtles and the oldest brother. He is the most hardworking student to Master Splinter and the study of Ninjutsu. Leo wears a blue mask and wields two ninjakens, also known as ninjatō.");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}