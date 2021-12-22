package com.example.madlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Story extends AppCompatActivity {

    TextView txt;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        txt = findViewById(R.id.story);
        int count = 0;
        String textAll="";
        String replace="";
        intent = getIntent();
        int file = intent.getIntExtra("index",0);
        ArrayList blanks = (ArrayList) intent.getSerializableExtra("list");
        System.out.println(blanks.get(0).toString());
        InputStream inputStream = getResources().openRawResource(file);
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
        String eachline = null;
        try {
            eachline = bufferedReader.readLine();
            System.out.println(eachline+" hello ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (eachline != null) {
            // `the words in the file are separated by space`, so to get each words
            String[] words = eachline.split(" ");
            for (String word:words
                 ) {
                if(word.contains("<"))
                {
                   word = word.replaceAll(word,blanks.get(count).toString());
                    count++;
                }
                textAll+=word+" ";
                System.out.println(textAll);
            }
            try {
                eachline = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        txt.setText(textAll);
    }
    public void MakeOtherStory(View view)
    {
        Intent i = new Intent(this,FillWords.class);
        startActivity(i);
        finish();
    }
}