package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    String dict[] = new String[852];
    TextView word;
    EditText guessText;
    TextView summary;
    int num;
    int guessRemaining = 6;
    String guessed="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        word = findViewById(R.id.textView3);
        guessText = findViewById(R.id.guessText);
        summary = findViewById(R.id.textView4);
        InputStream inputStream = getResources().openRawResource(R.raw.dictionary);
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
        String eachline = null;
        int count = 0;
        try {
            eachline = bufferedReader.readLine();
            while (eachline != null) {
                    dict[count] = eachline.toString();
                    eachline = bufferedReader.readLine();
                    count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        num = rand.nextInt(849);

        if(dict[num].length()>3)
        {
            for (int i = 0 ; i<dict[num].length(); i++)
            {
                if(i==0 || i==dict[num].length()-2) {
                    word.setText(word.getText() + "" + dict[num].charAt(i));
                }

                else
                    word.setText(word.getText()+"?");
            }
        }
        else
        {
            for (int i = 0 ; i<dict[num].length(); i++)
            {
                if(i==1)
                    word.setText(word.getText()+""+dict[num].charAt(i));
                else
                    word.setText(word.getText()+"?");
            }
        }
    }
    public void newWord(View view)
    {
        word.setText("");
        guessText.setText("");
        Random rand = new Random();
        num = rand.nextInt(849);
        if(dict[num].length()>3)
        {
            for (int i = 0 ; i<dict[num].length(); i++)
            {
                if(i==0 || i==dict[num].length()-2)
                    word.setText(word.getText()+""+dict[num].charAt(i));

                else
                    word.setText(word.getText()+"?");
            }
        }
        else
        {
            for (int i = 0 ; i<dict[num].length(); i++)
            {
                if(i==1)
                    word.setText(word.getText()+""+dict[num].charAt(i));
                else
                    word.setText(word.getText()+"?");
            }
        }
        summary.setText("you have guessed : none (6 guesses left)");
        guessRemaining = 6;
        guessed = "";

    }
    public void Guess(View view)
    {
        String fillText="";
        boolean checkGuess = false;
        String text = word.getText().toString();
    if(guessRemaining > 0) {
        if (guessText.getText().toString().length() > 1) {
            Toast.makeText(this, "Please enter single character", Toast.LENGTH_SHORT).show();
        } else {
            guessed += guessText.getText().toString();
            if (dict[num].contains(guessText.getText().toString())) {
                checkGuess = true;
                char[] fill = text.toCharArray();
                char[] originalWord = dict[num].toCharArray();
                for (int i = 0; i < dict[num].length(); i++) {
                    if (originalWord[i] == guessText.getText().toString().charAt(0)) {
                        fill[i] = guessText.getText().toString().charAt(0);
                        System.out.println("hello");
                    }
                }
                fillText = String.valueOf(fill);
                word.setText(fillText);
            }
            if (!checkGuess) {
                guessRemaining--;
            }
        }

        summary.setText("You have guessed: " + guessed + " (" + guessRemaining + " guesses left)");
        guessText.setText("");
        checkWin();
    }
    else
    {
        Toast.makeText(this, "Guess new word!", Toast.LENGTH_SHORT).show();
    }

    }
    public void checkWin()
    {
        if(dict[num].equals(word.getText().toString()))
        {
            summary.setText("Congratulations! You guessed correct");
        }
        else if(guessRemaining == 0)
        {
            summary.setText("Sorry! You Lost.");
        }

    }
}