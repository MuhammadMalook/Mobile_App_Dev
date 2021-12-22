package com.example.floating_context_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Contextual_menus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual_menus);
    }
    public void openFloatingMenu(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void openActionBar(View view)
    {
        Intent intent = new Intent(this,ActionBarMenu.class);
        startActivity(intent);
    }
}