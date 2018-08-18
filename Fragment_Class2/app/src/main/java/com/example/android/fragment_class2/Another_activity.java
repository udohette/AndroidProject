package com.example.android.fragment_class2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class Another_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_activity);
        Intent intent = getIntent();
        int index = intent.getIntExtra("index",0);
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if(fragmentB != null){
            fragmentB.changeData(index);
        }

    }
}
