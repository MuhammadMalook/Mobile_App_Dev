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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class updateRecord extends AppCompatActivity {

    EditText updateName,updatePhone,updateStreet,updateEmail,updateCity;
    String oldname;
    String fileName = "students.txt";
    ArrayList list = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        updateName = findViewById(R.id.NameUpdate);
        updatePhone = findViewById(R.id.PhoneUpdate);
        updateStreet = findViewById(R.id.StreetUpdate);
        updateEmail = findViewById(R.id.EmailUpdate);
        updateCity = findViewById(R.id.CityUpdate);
        Intent intent = getIntent();
        oldname = intent.getStringExtra("Name");
    }

    public void updateRecord(View view) throws IOException {
        File directory = getFilesDir();
        File file = new File(directory,fileName);

        FileInputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            System.out.println(line);
            String array[] = line.split(",");
            if(!array[0].equals(oldname))
            {
                list.add(line);
            }
            else
            {
                String updated=updateName.getText()+","+updatePhone.getText().toString()+","+updateStreet.getText().toString()+
                        ","+ updateEmail.getText().toString()+","+updateCity.getText().toString();
                list.add(updated);
            }
        }
        inputStream.close();

        FileOutputStream outputStream = openFileOutput(fileName,MODE_PRIVATE);
        for (int i = 0; i < list.size(); i++) {
            outputStream.write(list.get(i).toString().getBytes());
            outputStream.write("\n".getBytes());
        }
        Toast.makeText(this, "Record is Updated", Toast.LENGTH_SHORT).show();
    }
}