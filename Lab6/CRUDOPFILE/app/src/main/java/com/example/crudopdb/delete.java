package com.example.crudopdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class delete extends AppCompatActivity {

    EditText txt;
    String fileName = "students.txt";
    ArrayList list = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        txt = findViewById(R.id.nameDelete);
    }
    public void deleteItem(View view) throws IOException {
        File directory = getFilesDir();
        File file = new File(directory,fileName);

        FileInputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            System.out.println(line);
            String array[] = line.split(",");
            if(!array[0].equals(txt.getText().toString()))
            {
                list.add(line);
            }
        }
        inputStream.close();

        FileOutputStream outputStream = openFileOutput(fileName,MODE_PRIVATE);
        for (int i = 0; i < list.size(); i++) {
            outputStream.write(list.get(i).toString().getBytes());
            outputStream.write("\n".getBytes());
        }
        Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
    }
}