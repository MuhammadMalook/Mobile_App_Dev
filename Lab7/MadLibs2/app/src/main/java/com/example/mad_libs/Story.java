package com.example.mad_libs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Story extends AppCompatActivity {


    TextView txt;
    Intent intent;

    DBhelper dBhelper;
    FileOutputStream outputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        txt = findViewById(R.id.story);
        intent = getIntent();
        dBhelper= new DBhelper(this);

        try {
            outputStream = openFileOutput("story.txt",MODE_PRIVATE);
            outputStream.write(intent.getStringExtra("story").getBytes());
            outputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        File dir = this.getFilesDir();
        File file = new File(dir,"story.txt");

        InputStream inputStream=null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(inputStream);
        String text = "";
        while (scanner.hasNext())
        {
            text += scanner.nextLine();
        }
        txt.setText(text);
        dBhelper.insertStory(getResources().getResourceEntryName(FillWords.files[FillWords.indexfile]),text);
    }
    public void MakeOtherStory(View view)
    {
        Intent intent = new Intent(this,FillWords.class);
        startActivity(intent);
        finish();
    }
    public void showAllList(View view)
    {
        Intent intent = new Intent(this,showAllStories.class);
        startActivity(intent);
    }
}