package com.example.android.multithreadingexample;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private EditText editText;
    private ListView listView;
    private String[] listOfImages;
    private ProgressBar progressBar;
    private LinearLayout loadingSection = null;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.downloadURL);
        listView = (ListView) findViewById(R.id.urlList);
        listView.setOnItemClickListener(this);
        listOfImages = getResources().getStringArray(R.array.imageUrls);
        progressBar = (ProgressBar) findViewById(R.id.downloadProgress);
        handler = new Handler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void downloadImage(View view) {
        String url = editText.getText().toString();
        Thread myThread = new Thread(new DownloadImagesThread(url));
        myThread.start();

    }

    public boolean downloadImageUsingThread(String url) {
        boolean successful = false;
        URL downloadURL = null;
        HttpsURLConnection connection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;
        try {
            downloadURL = new URL(url);
            connection = (HttpsURLConnection) downloadURL.openConnection();
            inputStream = connection.getInputStream();
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()
                    + "/" + Uri.parse(url).getLastPathSegment());
            fileOutputStream = new FileOutputStream(file);
            L.m("" + file.getAbsolutePath());
            int read = -1;
            byte[] buffer = new byte[1024];
            while ((read = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, read);
            }
            successful = true;
        } catch (MalformedURLException e) {

        } catch (IOException e) {
            L.m(e + "");

        } finally {
            handler.post(new Runnable() {
                @Override
                public void run() {
                   loadingSection.setVisibility(View.GONE);

                }
            });

            if (connection != null) {
                connection.disconnect();
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                L.m(e + "");

            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    L.m(e + "");

                }
            }
        }
        return successful;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        editText.setText(listOfImages[position]);

    }

    private class DownloadImagesThread implements Runnable {

        private String url;

        public DownloadImagesThread(String url) {
            this.url = url;
        }

        @Override
        public void run() {
           handler.post(new Runnable() {
               @Override
               public void run() {
                  loadingSection.setVisibility(View.VISIBLE);

               }
           });

            downloadImageUsingThread(url);

        }
    }
}
