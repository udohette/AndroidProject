package com.example.dennis.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.dennis.sharedpreference", Context.MODE_PRIVATE);
        //sharedPreferences.edit().putString("username","Dennis").commit();
        String username = sharedPreferences.getString("username",DEFAULT);
        Log.i("username",username);
    }
}
