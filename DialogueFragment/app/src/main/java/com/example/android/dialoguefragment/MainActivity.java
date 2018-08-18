package com.example.android.dialoguefragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialogue.Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void MydialogueButton(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyDialogue dialogue = new MyDialogue();
        dialogue.show(fragmentManager,"Mydialog");
    }

    @Override
    public void onDialogMessage(String Message) {
        Toast.makeText(this,Message,Toast.LENGTH_SHORT).show();
    }
}
