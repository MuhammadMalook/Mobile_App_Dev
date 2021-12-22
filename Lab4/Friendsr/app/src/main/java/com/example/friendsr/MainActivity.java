package com.example.friendsr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int images[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = new int[]{R.drawable.chandler,R.drawable.joey,R.drawable.monica,R.drawable.phoebe,R.drawable.rachel,R.drawable.ross};

    }
    public void imageClicked(View view)
    {
        ImageView img = (ImageView) view;
        Intent intent = new Intent(this,Details.class);
        intent.putExtra("image",images[Integer.parseInt(img.getTag().toString())]);
        intent.putExtra("tag",Integer.parseInt(img.getTag().toString()));
        startActivity(intent);
    }
}