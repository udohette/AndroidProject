package com.example.android.sqldatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by DENNIS on 1/5/2017.
 */
public class Message {
    public  static void message(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

}
