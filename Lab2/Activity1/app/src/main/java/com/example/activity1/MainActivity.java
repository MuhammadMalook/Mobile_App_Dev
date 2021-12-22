package com.example.activity1;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
   int numberToGuess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("created");
        Random rand = new Random();
        numberToGuess = rand.nextInt(1000);
    }
    int numOfTries = 10;
    public void ValidateNumber(View view)
    {
        Button btn = findViewById(R.id.button2);
        Button validate = findViewById(R.id.button);
        TextView txt = findViewById(R.id.textView2);
        TextView guessBox = findViewById(R.id.guessBox);
        TextView remaining = findViewById(R.id.textView3);
        txt.setText("Guess a number between 1 and 1000 ");
        int guess = Integer.parseInt(guessBox.getText().toString());
        if(guess == numberToGuess)
        {
            txt.setText("You Guess Correctly");
            validate.setEnabled(false);
            btn.setVisibility(View.VISIBLE);
        }
        else if(guess<numberToGuess)
        {
            txt.setText("Too Low");
            numOfTries--;
        }
        else
        {
            txt.setText("Too High");
            numOfTries--;
        }
        remaining.setText("Remaining "+numOfTries);
        if(numOfTries == 0)
        {
            remaining.setText("You Lost!");
            validate.setEnabled(false);
            btn.setVisibility(View.VISIBLE);

        }
    }
    public void RestartGame(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        System.out.println("Started");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        System.out.println("resumed");
//    }
//
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        System.out.println("Paused");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        System.out.println("Stopped");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        System.out.println("restarted");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        System.out.println("Destroyed");
//    }
//
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        System.out.println("saved called");
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        System.out.println("restore");
//    }
}