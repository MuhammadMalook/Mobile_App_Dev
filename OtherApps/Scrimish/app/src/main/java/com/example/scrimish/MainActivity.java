package com.example.scrimish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText player1,player2;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);


    }
    public void startGame(View view)
    {
        preferences = getSharedPreferences("players",MODE_PRIVATE);
        Intent intent = new Intent(this,activity_game.class);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("player1",player1.getText().toString());
        editor.putString("player2",player2.getText().toString());
        editor.commit();
        startActivity(intent);
    }
}