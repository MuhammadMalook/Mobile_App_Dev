package com.example.mad_libs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FillWords extends AppCompatActivity {

    public static int[] files;
    String story="";
    ArrayList placeholders = new ArrayList();
    TextView summary;
    TextView fill;
    int countPlaceholders;
    EditText txt;
    String getWords[];
    public static int indexfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_words);
        files = new int[]{R.raw.madlib0,R.raw.madlib1,R.raw.madlib2,R.raw.madlib3,R.raw.madlib4};
        txt = findViewById(R.id.editTextTextPersonName);
        summary =findViewById(R.id.summary);
        fill = findViewById(R.id.fill);

        files = new int[]{R.raw.madlib0,R.raw.madlib1,R.raw.madlib2,R.raw.madlib3,R.raw.madlib4};
        Random rand = new Random();
        indexfile = rand.nextInt(4);

        InputStream inputStream = getResources().openRawResource(files[indexfile]);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext())
        {
            String holdWord = scanner.next();
            story+=holdWord+" ";
            if(holdWord.contains("<"))
            {
                placeholders.add(holdWord.substring(1,holdWord.length()-1));
                countPlaceholders++;
            }
        }
        txt.setHint(placeholders.get(0).toString());
        summary.setText(countPlaceholders+ " word(s) left");
        fill.setText("Please type a/an "+placeholders.get(0).toString());
        getWords = new String[placeholders.size()];

    }
    int index=0;
    int getWordIndex=1;
    public void newWord(View view)
    {
        if(!txt.getText().toString().equals("")) {
            getWords[index] = txt.getText().toString();
            index++;
            if(getWordIndex<placeholders.size()) {
                countPlaceholders--;
                summary.setText(countPlaceholders + " word(s) left");
                fill.setText("Please type a/an " + placeholders.get(getWordIndex).toString());
                txt.setHint(placeholders.get(getWordIndex).toString());
                getWordIndex++;
                txt.setText("");

            }
            else
            {
                String fillWords[] = story.split(" ");
                int ind = 0;
                for (int i = 0; i < fillWords.length; i++) {
                    if (fillWords[i].contains("<"))
                    {
                        System.out.println(fillWords[i]);
                        fillWords[i] = getWords[ind].toString();
                        ind++;
                    }
                }

                Intent intent = new Intent(this, Story.class);
                intent.putExtra("story", Arrays.toString(fillWords).replaceAll(",","").replaceAll("\\[","").replaceAll("\\]",""));
                startActivity(intent);
                finish();
            }
        }
    }
}