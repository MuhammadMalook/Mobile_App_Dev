package com.dot.consumer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import static android.content.ContentValues.TAG;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ListView list;
    LinearLayout layout;
    ArrayList<String> arrayList = new ArrayList<>();
    public static final Uri CONTENT_URI = Uri.parse("content://"+"com.dot.myProvider"+"/dictionary");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout =  findViewById(R.id.layout_second);
        list = findViewById(R.id.listview);
    }

    public void loadData(View view)
    {
        Cursor cr = getContentResolver().query(CONTENT_URI, null, null, null,null);
        StringBuilder builder = new StringBuilder();

        while(cr.moveToNext())
        {

            String word = cr.getString(0);
            arrayList.add(word);
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(adapter);
    }
}