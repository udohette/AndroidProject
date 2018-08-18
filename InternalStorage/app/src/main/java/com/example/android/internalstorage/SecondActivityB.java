package com.example.android.internalstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivityB extends AppCompatActivity {
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity_b);
        username = (EditText)findViewById(R.id.editText3);
        password = (EditText)findViewById(R.id.editText4);
    }
    public void load(View view){
        try {
            FileInputStream fileInputStream = openFileInput("dennis.txt");
            int read = -1;
            StringBuffer stringBuffer = new StringBuffer();
            while ((read = fileInputStream.read())!=-1){
                stringBuffer.append((char)read);
            }

            Log.d("Dennis",stringBuffer.toString());
            //Name char and Password char may differ; sp we need this;'
            String text1 = stringBuffer.substring(0,stringBuffer.indexOf(""));
            String text2 = stringBuffer.substring(stringBuffer.indexOf("")+1);
            username.setText(text1);
            password.setText(text2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
        Toast.makeText(this,"Load Successfully",Toast.LENGTH_SHORT).show();

    }
    public void previous(View view){
        Toast.makeText(this,"Previous Called",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
