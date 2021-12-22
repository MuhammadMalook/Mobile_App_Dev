package com.example.friendsr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Details extends AppCompatActivity {

    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ratingBar = findViewById(R.id.ratingBar);
        Intent intent = getIntent();
        int tag = Integer.parseInt(String.valueOf(intent.getIntExtra("tag",0)));
        ImageView img = findViewById(R.id.image);
        img.setImageResource(intent.getIntExtra("image",1));
        String details[] = getResources().getStringArray(R.array.friend_details);
        TextView detail = findViewById(R.id.detail);
        detail.setMovementMethod(new ScrollingMovementMethod());
        detail.setText(details[tag]);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this,"You rated them: "+ratingBar.getRating(), Toast.LENGTH_SHORT).show();
    }
}