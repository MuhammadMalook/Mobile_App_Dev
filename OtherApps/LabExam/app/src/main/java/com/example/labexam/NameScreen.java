package com.example.labexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameScreen extends AppCompatActivity {

    EditText txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_screen2);
        txt1  = findViewById(R.id.player1);
        txt2 = findViewById(R.id.player2);
    }
    public void onPlay(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("p1", txt1.getText().toString());
        intent.putExtra("p2",txt2.getText().toString());
        startActivityForResult(intent,123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}