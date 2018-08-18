package com.example.android.tutorial;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


    }
    public void process(View view) {
        Intent intent = null, chooser = null;
        if (view.getId() == R.id.button) {
            Intent intent1 = new Intent(android.content.Intent.ACTION_VIEW);
            intent1.setData(Uri.parse("geo:19.076,72.8777"));
            chooser = Intent.createChooser(intent1, "Launch Maps");
            startActivity(chooser);
        }
        if (view.getId() == R.id.button2) {
            Intent intent1 = new Intent(android.content.Intent.ACTION_VIEW);
            intent1.setData(Uri.parse("market://details?id=dolphin.developerscom"));
            chooser = Intent.createChooser(intent1, "launch Market");
            startActivity(chooser);
        }
        if (view.getId() == R.id.button3) {
            Intent intent1 = new Intent(Intent.ACTION_SEND);
            intent1.setData(Uri.parse("mailto:"));
            String[] to = {"udohette@gmail.com", "eddystic@yahoo.com"};
            intent1.putExtra(Intent.EXTRA_EMAIL, to);
            intent1.putExtra(Intent.EXTRA_SUBJECT, "Hi this was send from my App");
            intent1.putExtra(Intent.EXTRA_TEXT, "Hi xup, this is my First email message");
            intent1.setType("message/rfc822");
            chooser = Intent.createChooser(intent1, "send Email");
            startActivity(chooser);
        }
        if (view.getId() == R.id.sendImage) {
            Uri imageUri = Uri.parse("android.resource://android.Tutorial/drawable/" + R.drawable.fast_food);
            Intent intent1 = new Intent(Intent.ACTION_SEND);
            intent1.setType("image/*");
            intent1.putExtra(Intent.EXTRA_STREAM, imageUri);
            intent1.putExtra(Intent.EXTRA_TEXT, "Hey i have attached this image");
            chooser = Intent.createChooser(intent1, "send Image");
            startActivity(chooser);
        }
    }
}