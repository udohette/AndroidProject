package com.example.android.actionbardemo;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getGroupId()){
            case R.id.setting_id:
                Toast.makeText(getApplicationContext(),"Settings was selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.search:
                Toast.makeText(getApplicationContext(),"Search was selected",Toast.LENGTH_LONG).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }
    public void startChild(View view){
        startActivity(new Intent(this,ChildActiviyOne.class));
    }
}
