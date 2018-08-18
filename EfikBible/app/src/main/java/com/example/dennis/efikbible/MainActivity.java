package com.example.dennis.efikbible;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(int position) {
        FragmentManager manager = getSupportFragmentManager();
        ChapterFragment chapterFragment = (ChapterFragment) manager.findFragmentById(R.id.chapter_fragment);
        chapterFragment.changeData(position);

    }
}
