package com.example.dennis.encapsulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.widget.RelativeLayout.TRUE;

public class MainActivity extends AppCompatActivity {
    TextView displayTextView;
    Button display;
    Button hide;

    public void displayText(View view){
        displayTextView.setText("Am displaying now.");
        display = (Button)findViewById(R.id.display);
        display.setVisibility(View.VISIBLE);


    }
    public void hideText(View view){
        hide = (Button)findViewById(R.id.hide);
        displayTextView.setVisibility(View.GONE);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayTextView =  (TextView)findViewById(R.id.encapText);
    }
}
