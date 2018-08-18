package com.example.dennis.bible;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.Communication {
    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentA = (FragmentA)fragmentManager.findFragmentById(R.id.fragment);
        fragmentA.setCommunication(this);
    }

    @Override
    public void respond(int index) {
        fragmentB = (FragmentB) fragmentManager.findFragmentById(R.id.fragment2);
        if (fragmentB!= null && fragmentB.isVisible()){
            fragmentB.changeData(index);
        }
        else {
            Intent intent = new Intent(this,AnotherActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }

    }
}
