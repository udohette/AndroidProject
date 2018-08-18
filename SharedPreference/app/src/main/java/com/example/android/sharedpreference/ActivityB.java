package com.example.android.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity{
    public static final String DEFAULT = "N/A";
    TextView usernameTextview, passwordtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);
        usernameTextview = (TextView)findViewById(R.id.textView3);
        passwordtextView = (TextView)findViewById(R.id.textView4);
    }
    public void load(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("Name",DEFAULT);
        String password = sharedPreferences.getString("Password",DEFAULT);
        if(name.equals(DEFAULT)|| password.equals(DEFAULT)){
            Toast.makeText(this,"No Data was Found",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Data Loaded Successfully",Toast.LENGTH_SHORT).show();
            usernameTextview.setText(name);
            passwordtextView.setText(password);
        }
    }
    public void previous(View view){
        Toast.makeText(this,"previous",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
