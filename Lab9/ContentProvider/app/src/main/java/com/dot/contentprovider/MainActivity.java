package com.dot.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    EditText word, description;
    ContentValues values = new ContentValues();
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        description = findViewById(R.id.description);
        word = findViewById(R.id.word);
        layout = findViewById(R.id.linearLayout);


    }

    public void save(View view) {
        values.put("word",word.getText().toString());
        values.put("description",description.getText().toString());
        Uri uri =  getContentResolver().insert(CustomProvider.CONTENT_URI,values);
        //Toast.makeText(this,uri.toString(),Toast.LENGTH_LONG).show();
    }

}