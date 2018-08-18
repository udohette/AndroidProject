package com.example.android.sqldatabase;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    DennisHelper dennisHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dennisHelper = new DennisHelper(this);
        SQLiteDatabase sqLiteDatabase = dennisHelper.getWritableDatabase();

    }
}
