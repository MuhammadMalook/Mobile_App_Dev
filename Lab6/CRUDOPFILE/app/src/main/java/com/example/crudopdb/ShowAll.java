package com.example.crudopdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShowAll extends AppCompatActivity {
    
    ListView listView;
    ArrayList list;
    String filename = "students.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        listView = findViewById(R.id.list);
        list = new ArrayList();
        try {
            show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void show() throws FileNotFoundException {
        File directory = getFilesDir();
        File file = new File(directory,filename);
        System.out.println(file.toString());
        FileInputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            System.out.println(line);
            String array[] = line.split(",");
            list.add(array[0]);
        }
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.file,list);
        listView.setAdapter(adapter);
    }
}