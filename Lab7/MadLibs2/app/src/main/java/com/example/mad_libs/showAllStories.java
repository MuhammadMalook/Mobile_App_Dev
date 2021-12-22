package com.example.mad_libs;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class showAllStories extends AppCompatActivity {

    public static List<stories> list;
    DBhelper dBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_stories);
        dBhelper = new DBhelper(this);
        list = new ArrayList<stories>();
        Cursor cursor = dBhelper.getAll();


        if(cursor.moveToFirst())
        {
            do{
                stories story = new stories(cursor.getString(0),cursor.getString(1));
                list.add(story);
            }
            while (cursor.moveToNext());
        }
        MyAdapter adapter = new MyAdapter(this,R.layout.custom_list,list);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}