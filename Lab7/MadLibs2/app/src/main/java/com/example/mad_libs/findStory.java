package com.example.mad_libs;

import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class findStory extends FillWords{
    public static int[] files;
    String story="";
    ArrayList placeholders = new ArrayList();
    TextView summary;
    TextView fill;
    public static int index;
    int countPlaceholders;
    EditText txt;
    String getWords[];
    public void makeStory()
    {
        files = new int[]{R.raw.madlib0,R.raw.madlib1,R.raw.madlib2,R.raw.madlib3,R.raw.madlib4};
        txt = findViewById(R.id.editTextTextPersonName);
        summary =findViewById(R.id.summary);
        fill = findViewById(R.id.fill);

        files = new int[]{R.raw.madlib0,R.raw.madlib1,R.raw.madlib2,R.raw.madlib3,R.raw.madlib4};
        Random rand = new Random();
        index = rand.nextInt(4);

        InputStream inputStream = getResources().openRawResource(files[index]);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext())
        {
            String holdWord = scanner.next();
            story+=holdWord+" ";
            if(holdWord.contains("<"))
            {
                placeholders.add(holdWord.substring(1,holdWord.length()-1));
                countPlaceholders++;
            }
        }
        txt.setHint(placeholders.get(0).toString());
        summary.setText(countPlaceholders+ " word(s) left");
        fill.setText("Please type a/an "+placeholders.get(0).toString());
        getWords = new String[placeholders.size()];

    }
}
