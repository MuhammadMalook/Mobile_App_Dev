package com.example.mrpotatohead;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = new ImageView[]{findViewById(R.id.imageView3),findViewById(R.id.imageView4),findViewById(R.id.imageView9),findViewById(R.id.imageView10),findViewById(R.id.imageView6),findViewById(R.id.imageView7),findViewById(R.id.imageView8),findViewById(R.id.imageView11),findViewById(R.id.imageView13),findViewById(R.id.imageView12)};

    }
    public void checkUncheck(View view)
    {
        CheckBox checkBox = (CheckBox)view;
        int index =Integer.parseInt(checkBox.getTag().toString());
        if(checkBox.isChecked()){

            images[index].setVisibility(View.VISIBLE);
        }
        else
            images[index].setVisibility(View.INVISIBLE);
    }
}