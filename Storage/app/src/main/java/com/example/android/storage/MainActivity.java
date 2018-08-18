package com.example.android.storage;

import android.app.Notification;
import android.content.Intent;
import android.os.Environment;
import android.os.Message;
import android.support.v4.provider.DocumentFile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
    }
    public void InternalCache(View view){
        String data = editText.getText().toString();
        File folder = getCacheDir();
        File myFile = new File(folder,"myData1.txt");
        writeData(myFile,data);
    }

    public void ExternalCache(View view){
        String data = editText.getText().toString();
        File folder = getExternalCacheDir();
        File myFile = new File(folder,"myData2.txt");
        writeData(myFile,data);

    }
    public void ExternalPrivate(View view){
        String data = editText.getText().toString();
        File folder = getExternalFilesDir("Dennis");
        File myFile = new File(folder,"myData3.txt");
        writeData(myFile,data);

    }
    public void ExternalPublic(View view){
        String data = editText.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File myFile = new File(folder,"myData4.txt");
        writeData(myFile,data);


    }
    public void writeData (File myFile,String data){
        FileOutputStream fileOutputStream =null;
        try {
            fileOutputStream= new FileOutputStream(myFile);
            fileOutputStream.write(data.getBytes());
            message(data +"Was written successfully "+ myFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void next(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
    public void message(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
