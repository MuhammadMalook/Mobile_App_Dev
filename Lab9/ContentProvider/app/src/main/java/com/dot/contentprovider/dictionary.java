package com.dot.contentprovider;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class dictionary extends AppCompatActivity {

    ListView list;
    SearchView searchView;
    ArrayList<String> wordList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        wordList = new ArrayList<>();
        list = findViewById(R.id.listview);
        searchView = findViewById(R.id.serachview);
        load();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(wordList.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(getApplicationContext(), "No Match found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                    adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
    public void load()
    {
        if(adapter!=null)
            adapter.clear();

        Cursor cr = getContentResolver().query(CustomProvider.CONTENT_URI, null, null, null,null);
//        StringBuilder builder = new StringBuilder();

        ArrayList<String[]> arrayList = new ArrayList<String[]>();

        while(cr.moveToNext())
        {
            String word = cr.getString(0);
            String description = cr.getString(1);
            arrayList.add(new String[]{word,description});
            wordList.add(word);

        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,wordList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), ""+position, Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(), ""+ view.toString(), Toast.LENGTH_SHORT).show();

                  String[] desc = arrayList.get(wordList.indexOf(adapter.getItem(position)));
                    CustomDialog dialog = new CustomDialog();

                Bundle args = new Bundle();
                args.putString("description", desc[1]);
                dialog.setArguments(args);

                dialog.show(getSupportFragmentManager(), "");


            }
        });
    }
    public void addWord(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        System.out.println("OnRestart");
        load();
        super.onRestart();
    }

    @Override
    protected void onResume() {
        System.out.println("On resume");
        load();
        super.onResume();
    }
}