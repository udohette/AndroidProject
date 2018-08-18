package com.example.android.alertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void  MyAlertDialog(View view){
        MyAlert myAlert = new MyAlert();
        myAlert.show(getSupportFragmentManager(),"My Alert");


    }
}
