package com.example.dicerollgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int images[];
    ImageView img1,img2;
    TextView text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = new int[]{R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6};
        text1 = findViewById(R.id.textView4);
        text2 = findViewById(R.id.textView5);
        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void onRollDice(View view)
    {
        Random rand = new Random();
        int num1 = rand.nextInt(6);
        int num2 = rand.nextInt(6);
        img1.setImageResource(images[num1]);
        img2.setImageResource(images[num2]);
        text1.setText(""+(num1+1));
        text2.setText(""+(num2+1));

        if(num1 == num2)
        {
            Toast.makeText(this, "User has Won", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Casino has won", Toast.LENGTH_SHORT).show();

    }
}