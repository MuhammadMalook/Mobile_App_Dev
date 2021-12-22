package com.example.roll_dice_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int img[];
    ImageView img1,img2;
    TextView txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = new int[]{R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6};
        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView3);
        txt1 = findViewById(R.id.textView3);
        txt2  = findViewById(R.id.textView4);
    }
    public void onRollDice(View view)
    {
        Random rand = new Random();
        int num1,num2;
        num1 = rand.nextInt(5);
        num2 = rand.nextInt(5);
        img1.setImageResource(img[num1]);
        img2.setImageResource(img[num2]);
        txt1.setText(""+(num1+1));
        txt2.setText(""+(num2+1));
        if(num1 == num2)
        {
            Toast.makeText(this, "User Won", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Casino Win", Toast.LENGTH_SHORT).show();
        }
    }
}