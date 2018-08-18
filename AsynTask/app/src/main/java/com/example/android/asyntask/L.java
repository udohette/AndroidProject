package com.example.android.asyntask;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by DENNIS on 2/17/2017.
 */
public class L {
    public static void m(String message){
        Log.d("DENNIS",message);
    }
    public static void s(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
