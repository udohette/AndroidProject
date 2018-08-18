package com.example.android.sqldatabaseinsert;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by DENNIS on 1/10/2017.
 */
public class Message {
    public  static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

    }
}
