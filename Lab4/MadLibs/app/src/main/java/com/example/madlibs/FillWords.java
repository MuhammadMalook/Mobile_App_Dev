package com.example.madlibs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class FillWords extends AppCompatActivity {

    int[] files;
    int index = 0;
    ArrayList blanks;
    EditText txt;
    int count = 1;
    TextView summary;
    TextView fill;
    ArrayList listofWords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_words);
        files = new int[]{R.raw.madlib0,R.raw.madlib1,R.raw.madlib2,R.raw.madlib3,R.raw.madlib4};
        txt = findViewById(R.id.editTextTextPersonName);
        summary =findViewById(R.id.summary);
        fill = findViewById(R.id.fill);

        Random rand = new Random();
        index = rand.nextInt(4);
        blanks = new ArrayList();
        listofWords = new ArrayList();

        InputStream inputStream = getResources().openRawResource(files[index]);
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
        String eachline = null;
        try {
            eachline = bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        while (eachline != null) {
            // `the words in the file are separated by space`, so to get each words
            String[] words = eachline.split(" ");
            System.out.println(words + " hello");
            if(eachline.contains("<"))
            {
                for (String word:words
                     ) {
                    if(word.contains("<"))
                    {
                        String text = word.substring(word.indexOf("<")+1,word.indexOf(">"));
                        System.out.println(text);
                        blanks.add(text);
                    }

                }

            }
            try {
                eachline = bufferedReader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        txt.setHint(blanks.get(0).toString());
        summary.setText((blanks.size())+" word(s) left");
        fill.setText("please type a/an "+blanks.get(0));
    }
    public void newWord(View view)
    {
        if(!txt.getText().toString().equals("")) {
            listofWords.add(txt.getText().toString());
            if (count < blanks.size()) {
                txt.setText("");
                txt.setHint(blanks.get(count).toString());
                summary.setText((blanks.size() - count) + " word(s) left");
                fill.setText("please type a/an " + blanks.get(count));
                count++;
            } else {
                Intent intent = new Intent(this, Story.class);
                intent.putExtra("index", files[index]);
                intent.putExtra("list", listofWords);
                startActivity(intent);
                finish();
            }
        }
        else
        {
            Toast.makeText(this, "please enter text", Toast.LENGTH_SHORT).show();
        }
    }
}