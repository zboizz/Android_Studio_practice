package com.example.chapter_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.ex04_01);
        setContentView(R.layout.ex04_02);
       //setContentView(R.layout.ex04_03);
    }
}
