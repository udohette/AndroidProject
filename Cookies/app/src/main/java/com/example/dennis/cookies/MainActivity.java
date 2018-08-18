package com.example.dennis.cookies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public void eatCookies(View view) {

        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        // ImageView imageView1 = (ImageView)findViewById(R.id.image2);
        imageView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
        Log.i("", "eatCookies: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // called when cookies should be  eating
        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        imageView.animate().rotationY(0.5f).setDuration(2000);
    }


}
