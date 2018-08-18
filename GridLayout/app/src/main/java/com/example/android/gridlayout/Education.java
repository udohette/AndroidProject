package com.example.android.gridlayout;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class Education extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ArrayList<EfikPhrase> education_category = new ArrayList<>();
        education_category.add(new EfikPhrase("Book; Letter; Writing; Certificate; Official Document","ŋwed"));
        education_category.add(new EfikPhrase("Calculation","Ibat"));
        education_category.add(new EfikPhrase("Efik Language","Ikɔ Efik"));
        education_category.add(new EfikPhrase("English Language","Ikɔ Mbakara"));
        education_category.add(new EfikPhrase("Examination","Udomo"));
        education_category.add(new EfikPhrase("Knowledge","Ifiɔk"));
        education_category.add(new EfikPhrase("Place Of Learning; School; College; University","Ufɔk ŋwed"));
        education_category.add(new EfikPhrase("Read; Study","Kot"));
        education_category.add(new EfikPhrase("Scholar","Owo ŋwed"));
        education_category.add(new EfikPhrase("Student; Pupil","Eyen Ufɔk ŋwed"));
        education_category.add(new EfikPhrase("Teacher","Akpep ŋwed"));
        education_category.add(new EfikPhrase("Word","Ikɔ"));
        education_category.add(new EfikPhrase("Write","Wet"));
        education_category.add(new EfikPhrase("Writer","Andiwet"));
        EfikeAdapter efikeAdapter = new EfikeAdapter(this,education_category,R.color.Category_Education);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(efikeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.filter_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchView2).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);
        setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
