package com.example.android.sqldatabaseinsert;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText password,username, name;
    DennisDataBaseAdapter dennisHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = (EditText)findViewById(R.id.passwordValue);
        username = (EditText)findViewById(R.id.userNameValue);
        name = (EditText)findViewById(R.id.name);
        dennisHelper  = new DennisDataBaseAdapter(this);
    }
    public  void addUser(View view){
        String User = username.getText().toString();
        String pass = password.getText().toString();
       long id = dennisHelper.insertData(User,pass);
        if(id<0){
            com.example.android.sqldatabaseinsert.Message.message(this,"Successfully Inserted a row");

        }else {
            com.example.android.sqldatabaseinsert.Message.message(this,"Not  Inserted");

        }


    }
    public void viewDetails(View view){
        String data = dennisHelper.getAllData();
        com.example.android.sqldatabaseinsert.Message.message(this,data);

    }
    public void getDetails(View view){
        String s1 = name.getText().toString();
        String d2 = dennisHelper.getData(s1);
        com.example.android.sqldatabaseinsert.Message.message(this,d2);
    }
}
