package com.example.android.actionbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ChildActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_activity_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
