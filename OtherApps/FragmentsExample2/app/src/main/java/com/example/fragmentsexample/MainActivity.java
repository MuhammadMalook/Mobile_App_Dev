package com.example.fragmentsexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    Boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 fragment1 = new fragment1();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment1,fragment1).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        transaction = fragmentManager.beginTransaction();
        switch (item.getItemId())
        {
            case R.id.one:
                fragment1 fr1 = new fragment1();
                transaction.replace(R.id.fragment1,fr1);
                break;
            case R.id.two:
                fragment2 fr2 = new fragment2();
                transaction.replace(R.id.fragment1,fr2);
                break;
            case R.id.three:
                fragment3 fr3 = new fragment3();
                transaction.replace(R.id.fragment1,fr3);
                break;
        }
        System.out.println(item.getItemId() + " "+ R.id.one);
        transaction.commit();
        return super.onOptionsItemSelected(item);
    }
}