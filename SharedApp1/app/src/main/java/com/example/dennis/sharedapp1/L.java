package com.example.dennis.sharedapp1;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by DENNIS on 1/26/2018.
 */

public class L {
    public static void m(String message){
        Log.d("Dennis", message);
    }
    public static void s(Context context, String message){
        Toast.makeText(context, message,Toast.LENGTH_SHORT).show();
    }
}
