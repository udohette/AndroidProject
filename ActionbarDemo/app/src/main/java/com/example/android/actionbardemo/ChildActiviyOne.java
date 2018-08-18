package com.example.android.actionbardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class ChildActiviyOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_activiy_one);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void startChild(View view){
        startActivity(new Intent(this,ChildActivityTwo.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.chlild_activity_one,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
