package com.example.android.internalstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
    }
    public void save(View view){
        String text1 = username.getText().toString();//Dennis
        String text2 = password.getText().toString();// 1234
        File file = null;
        text1 = text1+"";//Dennis
        FileOutputStream fileOutputStream = null;
        try {
            file = getFilesDir();
            fileOutputStream = openFileOutput("dennis.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            fileOutputStream.write(text2.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("Dennis",e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("Dennis",e.toString());
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                Log.d("Dennis",e.toString());
                e.printStackTrace();
            }
        }

        //Dennis 1234
        Toast.makeText(this,"Data Save Succefully"+file+" /dennis.txt",Toast.LENGTH_SHORT).show();

    }
    public void next(View view){
        Toast.makeText(this,"next",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,SecondActivityB.class);
        startActivity(intent);

    }
}
