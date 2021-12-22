package com.example.crudopdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class update extends AppCompatActivity {


    EditText txt;
    String fileName = "students.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        txt = findViewById(R.id.updateName);
    }
    public void update(View view) throws IOException {
        File directory = getFilesDir();
        File file = new File(directory,fileName);

        FileInputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);

        Boolean flag=false;
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            System.out.println(line);
            String array[] = line.split(",");
            if(array[0].equals(txt.getText().toString()))
            {
                flag=true;
            }
        }
        inputStream.close();
        if(flag)
        {
            Intent intent = new Intent(this,updateRecord.class);
            intent.putExtra("Name",txt.getText().toString());
            startActivity(intent);
        }
        else
            Toast.makeText(this, "No record found with this name", Toast.LENGTH_SHORT).show();
    }
}