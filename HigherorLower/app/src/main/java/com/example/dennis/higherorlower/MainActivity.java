package com.example.dennis.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void makeToast(String string){
        Toast.makeText(MainActivity.this,string,Toast.LENGTH_SHORT).show();
    }
    public void guessMe(View view){
        EditText editText = (EditText)findViewById(R.id.edit_text);
        Button button = (Button)findViewById(R.id.clickMe);
        int intNumber = Integer.parseInt(editText.getText().toString());
        if (intNumber > randomNumber){
            makeToast("Lower!");
        }else if (intNumber < randomNumber){
            makeToast("Higher!");
        }else {
            makeToast("That's Right! Try again");

        }
        Random random = new Random();
        randomNumber = random.nextInt(20) + 3;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        randomNumber = random.nextInt(20) + 3;
    }
}
