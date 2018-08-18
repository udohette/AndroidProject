package com.example.android.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity{
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
    }
    public void saveBotton(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = (SharedPreferences.Editor) sharedPreferences.edit();
        editor.putString("Name",username.getText().toString());
        editor.putString("Password",password.getText().toString());
        editor.apply();
        Toast.makeText(this,"Data was Saved Successfully",Toast.LENGTH_SHORT).show();

    }
    public void next(View view){
        Toast.makeText(this,"next",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ActivityB.class);
        startActivity(intent);

    }
}
