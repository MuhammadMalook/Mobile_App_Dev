package com.example.labexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView p1,p2 , active,u1,u2;
    int images[];
    int Shuffle[];
    String p1Name,p2Name;
    ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        Intent intent = getIntent();
        p1.setText(intent.getStringExtra("p1"));
        p2.setText(intent.getStringExtra("p2"));

        img1 = new ImageView(this);
        img2 = new ImageView(this);

        u1=findViewById(R.id.u1);
        u2 =findViewById(R.id.u2);
        u1.setText("0");
        u2.setText("0");

        p1Name = intent.getStringExtra("p1");
        p2Name = intent.getStringExtra("p2");
        images = new int[]{R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.two,R.drawable.two,R.drawable.two,R.drawable.two,R.drawable.three,
                R.drawable.three,R.drawable.three,R.drawable.three,R.drawable.four,R.drawable.four,R.drawable.four,R.drawable.four,R.drawable.five,R.drawable.five,
                R.drawable.five,R.drawable.five,R.drawable.six,R.drawable.six,R.drawable.six,R.drawable.six,R.drawable.seven,R.drawable.seven,R.drawable.seven,R.drawable.seven,
        R.drawable.eight,R.drawable.eight,R.drawable.eight,R.drawable.eight,R.drawable.nine,R.drawable.nine,R.drawable.nine,R.drawable.nine,R.drawable.jack,R.drawable.jack,R.drawable.jack,R.drawable.jack,
        R.drawable.king,R.drawable.king,R.drawable.king,R.drawable.king,R.drawable.queen,R.drawable.queen,R.drawable.queen,R.drawable.queen,R.drawable.ace,R.drawable.ace,R.drawable.ace,R.drawable.ace,};
        Shuffle = new int[images.length];

        Random rand = new Random();

        for (int i = 0; i < images.length; i++) {
            int randomIndexToSwap = rand.nextInt(images.length);
            int temp = images[randomIndexToSwap];
            images[randomIndexToSwap] = images[i];
            images[i] = temp;
        }
        active  = findViewById(R.id.textView4);
        active.setText(p1Name+" is Active");

    }
    public int activePlayer=1;
    int player1Score=0,player2Score=0;
    boolean pl1 = true,pl2=true;
    public void onHitMe(View view)
    {
        Random rand = new Random();
        int number = rand.nextInt(images.length);
        if(activePlayer==1 && pl1)
        {
            androidx.gridlayout.widget.GridLayout view1 =  (androidx.gridlayout.widget.GridLayout) findViewById(R.id.user1);
            img1.setImageResource(images[number]);
            view1.removeView(img1);
            view1.addView(img1);
            if(images[number] == R.drawable.ace)
            {
                player1Score+=11;
                u1.setText(u1.getText()+"+"+11);
            }
            else  if(images[number] == R.drawable.king)
            {
                player1Score+=10;
                u1.setText(u1.getText()+"+"+10);
            }
            else  if(images[number] == R.drawable.queen)
            {
                player1Score+=10;
                u1.setText(u1.getText()+"+"+10);
            }
            else  if(images[number] == R.drawable.jack)
            {
                player1Score+=10;
                u1.setText(u1.getText()+"+"+10);
            }
            else  if(images[number] == R.drawable.one)
            {
                player1Score+=1;
                u1.setText(u1.getText()+"+"+1);
            }
            else  if(images[number] == R.drawable.two)
            {
                player1Score+=2;
                u1.setText(u1.getText()+"+"+2);
            }
            else  if(images[number] == R.drawable.three)
            {
                player1Score+=3;
                u1.setText(u1.getText()+"+"+3);
            }
            else  if(images[number] == R.drawable.four)
            {
                player1Score+=4;
                u1.setText(u1.getText()+"+"+4);
            }
            else  if(images[number] == R.drawable.five)
            {
                player1Score+=5;
                u1.setText(u1.getText()+"+"+5);
            }
            else  if(images[number] == R.drawable.six)
            {
                player1Score+=6;
                u1.setText(u1.getText()+"+"+6);
            }
            else  if(images[number] == R.drawable.seven)
            {
                player1Score+=7;
                u1.setText(u1.getText()+"+"+7);
            }
            else  if(images[number] == R.drawable.eight)
            {
                player1Score+=8;
                u1.setText(u1.getText()+"+"+8);
            }
            else  if(images[number] == R.drawable.nine)
            {
                player1Score+=9;
                u1.setText(u1.getText()+"+"+9);
            }
            p1.setText(p1Name+":"+player1Score);
            checkForWin();
            if(pl2) {
                activePlayer = 2;
                active.setText(p2Name + " is Active Player");
            }

        }
        else if(activePlayer == 2 && pl2)
        {
            androidx.gridlayout.widget.GridLayout view1 =  (androidx.gridlayout.widget.GridLayout) findViewById(R.id.user2);
            img2.setImageResource(images[number]);
            view1.removeView(img2);
            view1.addView(img2);
            if(images[number] == R.drawable.ace)
            {
                player2Score+=11;
                u2.setText(u2.getText()+"+"+11);
            }
            else  if(images[number] == R.drawable.king)
            {
                player2Score+=10;
                u2.setText(u2.getText()+"+"+10);
            }
            else  if(images[number] == R.drawable.queen)
            {
                player2Score+=10;
                u2.setText(u2.getText()+"+"+10);
            }
            else  if(images[number] == R.drawable.jack)
            {
                player2Score+=10;
                u2.setText(u2.getText()+"+"+10);
            }
            else  if(images[number] == R.drawable.one)
            {
                player2Score+=1;
                u2.setText(u2.getText()+"+"+1);
            }
            else  if(images[number] == R.drawable.two)
            {
                player2Score+=2;
                u2.setText(u2.getText()+"+"+2);
            }
            else  if(images[number] == R.drawable.three)
            {
                player2Score+=3;
                u2.setText(u2.getText()+"+"+33);
            }
            else  if(images[number] == R.drawable.four)
            {
                player2Score+=4;
                u2.setText(u2.getText()+"+"+4);
            }
            else  if(images[number] == R.drawable.five)
            {
                player2Score+=5;
                u2.setText(u2.getText()+"+"+5);
            }
            else  if(images[number] == R.drawable.six)
            {
                player2Score+=6;
                u2.setText(u2.getText()+"+"+6);
            }
            else  if(images[number] == R.drawable.seven)
            {
                player2Score+=7;
                u2.setText(u2.getText()+"+"+7);
            }
            else  if(images[number] == R.drawable.eight)
            {
                player2Score+=8;
                u2.setText(u2.getText()+"+"+8);
            }
            else  if(images[number] == R.drawable.nine)
            {
                player2Score+=9;
                u2.setText(u2.getText()+"+"+9);
            }
            p2.setText(p2Name+":"+player2Score);
            checkForWin();
            if(pl1) {
                activePlayer = 1;
                active.setText(p1Name + " is Active Player");
            }
        }
    }
    public void onStand(View view)
    {
        if(activePlayer==1)
        {
            pl1 = false;
            activePlayer = 2;
            active.setText(p2Name + " is Active Player");
        }
        else if(activePlayer == 2)
        {
            pl2 = false;
            activePlayer=1;
            active.setText(p1Name + " is Active Player");
        }
        if(pl1==false && pl2 == false)
        {
            if((player1Score>player2Score) && player1Score<21)
            {
                Toast.makeText(this,p1Name+" has won", Toast.LENGTH_SHORT).show();
                finish();
            }
            else if ((player2Score>player1Score) && player2Score<21)
            {
                Toast.makeText(this, p2Name+" has won", Toast.LENGTH_SHORT).show();
                finish();
            }
            else {
                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
    public void checkForWin()
    {
        if(player1Score>21 && player2Score<21)
        {
            Toast.makeText(this, p2Name+ " has Won", Toast.LENGTH_SHORT).show();
            finish();
        }
        else if(player2Score == 21)
        {
            Toast.makeText(this, p2Name+" has won", Toast.LENGTH_SHORT).show();
            finish();
        }
        else if(player1Score == 21 && player2Score<21)
        {
            Toast.makeText(this, p1Name+" has Won", Toast.LENGTH_SHORT).show();
            finish();
        }
        else if(player2Score>21)
        {
            Toast.makeText(this, p1Name+" has won", Toast.LENGTH_SHORT).show();
            finish();
        }

    }


}