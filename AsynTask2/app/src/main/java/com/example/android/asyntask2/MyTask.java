package com.example.android.asyntask2;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by DENNIS on 2/21/2017.
 */
public class MyTask extends AsyncTask<String, Integer, Boolean> {
    private int calculatedProgress = 0;
    private int contentLength = -1;
    private int counter = 0;
    private Context context;

    public MyTask(Context context) {
        onAttach(context);

    }

    public void onAttach(Context context) {
        this.context = context;

    }

    public void onDetach() {
        context = null;

    }


    @Override
    protected void onPreExecute() {
        if (context != null) {
            ((MainActivity) context).showProgressBarBeforeDownloading();

        }


    }

    @Override
    protected Boolean doInBackground(String... params) {
        boolean successful = false;
        URL downloadURL = null;
        HttpsURLConnection connection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;
        try {
            downloadURL = new URL(params[0]);
            connection = (HttpsURLConnection) downloadURL.openConnection();
            contentLength = connection.getContentLength();
            inputStream = connection.getInputStream();
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()
                    + "/" + Uri.parse(params[0]).getLastPathSegment());
            fileOutputStream = new FileOutputStream(file);
            L.m("" + file.getAbsolutePath());
            int read = -1;
            byte[] buffer = new byte[1024];
            while ((read = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, read);
                counter = counter + read;
                publishProgress(counter);
            }
            successful = true;
        } catch (MalformedURLException e) {

        } catch (IOException e) {
            L.m(e + "");

        } finally {

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
    protected void onProgressUpdate(Integer... values) {

        if (context == null) {
            L.m("Skipping progress update since context is null");
        } else {
            calculatedProgress = (int) (((double) values[0] / contentLength) * 100);
            ((MainActivity) context).updateProgress(calculatedProgress);
        }

    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (context != null) {
            ((MainActivity) context).hideProgressBarAfterDownloading();

        }


    }
}


