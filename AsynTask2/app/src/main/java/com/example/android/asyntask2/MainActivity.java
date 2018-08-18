package com.example.android.asyntask2;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    EditText selectionText;
    ProgressBar downloadImagesProgress;
    ListView chooseImageList;
    String[] listOfImages;
    NonUITaskFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadImagesProgress = (ProgressBar) findViewById(R.id.downloadProgress);
        selectionText = (EditText) findViewById(R.id.UrlSelectionText);
        listOfImages = getResources().getStringArray(R.array.imageUrls);
        chooseImageList = (ListView) findViewById(R.id.chooseImageList);
        chooseImageList.setOnItemClickListener(this);
        if (savedInstanceState == null) {
            fragment = new NonUITaskFragment();
            getFragmentManager().beginTransaction().add(fragment, "TaskFragment").commit();
        } else {
            fragment = (NonUITaskFragment) getFragmentManager().findFragmentByTag("TaskFragment");
        }
        if (fragment != null){
            if (fragment.myTask != null && fragment.myTask.getStatus() == AsyncTask.Status.RUNNING){
                downloadImagesProgress.setVisibility(View.VISIBLE);

            }
        }

    }

    public void DownloadImage(View v) {
        if (selectionText.getText().toString() != null && selectionText.getText().toString().length() > 0) {
            fragment.beginTask(selectionText.getText().toString());


        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectionText.setText(listOfImages[position]);

    }
    public void updateProgress(int progress){
        downloadImagesProgress.setProgress(progress);
    }
    public void showProgressBarBeforeDownloading(){
        if (fragment.myTask != null){
            if (downloadImagesProgress.getVisibility() != View.VISIBLE
                    && downloadImagesProgress.getProgress()!= downloadImagesProgress.getMax()){
                downloadImagesProgress.setVisibility(View.VISIBLE);
            }

        }
    }
    public void hideProgressBarAfterDownloading(){
        if (fragment.myTask != null){
            if (downloadImagesProgress.getVisibility()==View.VISIBLE){
                downloadImagesProgress.setVisibility(View.GONE);
            }
        }

    }
}


