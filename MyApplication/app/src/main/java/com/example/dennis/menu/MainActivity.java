package com.example.dennis.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void printToLogs(View view) {
        TextView textView = (TextView)findViewById(R.id.menu_item_1);
        String t = textView.getText().toString();
        Log.d("MainAcitvity", t);
        TextView textView1 = (TextView)findViewById(R.id.menu_item_2);
        String t2 = textView1.getText().toString();
        Log.d("MainActivity", t2);
        TextView textView2 = (TextView)findViewById(R.id.menu_item_3);
        textView2.setText("Print Menu to Logs");
        // Find first menu item TextView and print the text to the logs

        // Find second menu item TextView and print the text to the logs

        // Find third menu item TextView and print the text to the logs

    }
}
