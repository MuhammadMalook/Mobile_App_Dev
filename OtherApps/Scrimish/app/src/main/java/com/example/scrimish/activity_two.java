package com.example.scrimish;


import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class activity_two extends AppCompatActivity {


    LinearLayout layout;
    int card_index = 0;
    Card[] cards = new Card[25];
    TextView tv;
    public int cardPicked=0;
    public int deckCount=0;
    public int fifteen=15;

    TextView player2;
    public FrameLayout deck5[];
    ArrayList<Card> player_one_cards;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        player2 = findViewById(R.id.textView15);
        layout = findViewById(R.id.two_selection);
        Intent intent = getIntent();
        player_one_cards = intent.getParcelableArrayListExtra("player_one_cards");
        Log.d(TAG, "onCreate: "+player_one_cards.size());
//        Log.d(TAG, "onCreate: "+ Arrays.toString(new ArrayList[]{player_one_cards}));
        instantiateFrameLayouts();

        SharedPreferences preferences = getSharedPreferences("players",MODE_PRIVATE);
        player2.setText(preferences.getString("player2","player 2") + " Cards");
    }
    public void instantiateFrameLayouts() {
        LinearLayout decks = findViewById(R.id.decks);
        deck5 = new FrameLayout[5];
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        for (int i = 0; i < deck5.length; i++) {
            deck5[i] = new FrameLayout(this);
            deck5[i].setLayoutParams(params);
            decks.addView(deck5[i]);
        }
    }


    public void selectCard(View v) {
        ImageView v1 = (ImageView) v;
        if (cardPicked > 24 || v1.getTag().equals("back_cover"))
            return;

        String tagOfCard = v1.getTag().toString();
        ImageView imageView = new ImageView(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(140, 180);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.setMargins(0, 0, 0, fifteen);
        fifteen -= 10;
        imageView.setLayoutParams(layoutParams);

        ImageView im = (ImageView) v;
        Drawable drawable = im.getDrawable();


        imageView.setImageDrawable(drawable);
        switch (tagOfCard) {
            case "crown":
                cards[card_index] = new Card("crown", 100, R.drawable.crown);break;
            case "a": cards[card_index] = new Card("archer", 10, R.drawable.archer);break;
            case "s": cards[card_index] = new Card("shield", 0, R.drawable.sheild);break;
            case "one": cards[card_index] = new Card("dagger", 1, R.drawable.one);break;
            case "two": cards[card_index] = new Card("sword", 2, R.drawable.two);break;
            case "three": cards[card_index] = new Card("star", 3, R.drawable.three);break;
            case "four": cards[card_index] = new Card("axe", 4, R.drawable.four);break;
            case "five": cards[card_index] = new Card("halberd", 5, R.drawable.five);break;
            case "six": cards[card_index] = new Card("longSword", 6, R.drawable.six);break;
        }
        deck5[deckCount].addView(imageView);
        cardPicked++;
        card_index++;

        if (cardPicked % 5 == 0) {
            deckCount++;
            fifteen = 15;
        }
        Drawable draw = getResources().getDrawable(R.drawable.back_cover);
        im.setImageDrawable(draw);
        im.setTag("back_cover");

    }

    public void Start(View view)
    {
        if(card_index<25)
        {

            Snackbar.make(layout, "please Select 25 cards First  ", Snackbar.LENGTH_LONG);
            return;
        }
        else {
            Intent intent = new Intent(this,MainGame.class);
            intent.putParcelableArrayListExtra("player_two_cards",new ArrayList<Card>(Arrays.asList(cards)));
            intent.putParcelableArrayListExtra("player_one_cards",player_one_cards);
            startActivity(intent);
        }


    }
}