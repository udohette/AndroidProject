package com.example.dennis.sharedapp1;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private EditText selectionText;
    private ProgressBar downloadProgress;
    private String[] listOfImages;
    ListView chooseImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chooseImageList = (ListView) findViewById(R.id.chooseImageList);
        selectionText = (EditText) findViewById(R.id.yourUrlSelection);
        downloadProgress = (ProgressBar) findViewById(R.id.downloadProgress);
        listOfImages = getResources().getStringArray(R.array.imageUrl);
        chooseImageList.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void downloadImage(View view) {
        if (selectionText.getText().toString() != null && selectionText.getText().toString().length() > 0) {
            MyTask myTask = new MyTask();
            myTask.execute(selectionText.getText().toString());
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectionText.setText(listOfImages[position]);

    }
    class MyTask extends AsyncTask<String, Integer, Boolean>{
        private int contentLength = -1;
        private int counter = 0;
        private int calculatedProgress = 0;
        @Override
        protected void onPreExecute() {
            downloadProgress.setProgress(View.VISIBLE);

        }

        @Override
        protected Boolean doInBackground(String... params) {
            boolean successful = false;
            URL downloadUrl = null;
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            FileOutputStream fileOutputStream = null;
            File file = null;
            try {
                downloadUrl = new URL(params[0]);
                connection = (HttpURLConnection) downloadUrl.openConnection();
                contentLength = connection.getContentLength();
                inputStream = connection.getInputStream();
                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile() + "/" +
                        Uri.parse(params[0]).getLastPathSegment());
                L.m("" + file.getAbsoluteFile());
            } catch (MalformedURLException e) {
                int read = -1;
                byte[] buffer = new byte[1024];
                try {
                    while ((read = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, read);
                        counter = counter + read;
                        L.m("counter"+ "counter"+ "Length"+ contentLength);
                        publishProgress(counter);

                    }
                    return successful = true;
                } catch (IOException e1) {
                    L.m(e + "");

                }
                e.printStackTrace();
            } catch (IOException e) {
                L.m(e + "");
            } finally {

            }
            if (connection != null) {
                connection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    L.m(e + "");

                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    L.m(e + "");

                }
            }
            return successful;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            calculatedProgress = (int)(((double)values[0]/contentLength)*100);
            downloadProgress.setProgress(calculatedProgress);

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            downloadProgress.setProgress(View.GONE);

        }
    }

}
