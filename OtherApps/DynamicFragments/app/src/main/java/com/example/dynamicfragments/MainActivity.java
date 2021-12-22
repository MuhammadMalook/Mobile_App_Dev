package com.example.dynamicfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
    }
    public void FirstFragment(View view)
    {
        transaction = manager.beginTransaction();
        firstFragment fragment = new firstFragment();
        transaction.replace(R.id.fragment,fragment);
        transaction.commit();
    }
    public void SecondFragment(View view)
    {
        transaction = manager.beginTransaction();
        secondFragment fragment = new secondFragment();
        transaction.replace(R.id.fragment,fragment);
        transaction.commit();
    }
}