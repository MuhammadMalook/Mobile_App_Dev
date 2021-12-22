package com.example.scrimish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText player1,player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);
    }
    public void startGame(View view)
    {
        Intent intent = new Intent(this,scrimish.class);
        intent.putExtra("player1",player1.getText().toString());
        intent.putExtra("player2",player2.getText().toString());
        startActivity(intent);
    }
}