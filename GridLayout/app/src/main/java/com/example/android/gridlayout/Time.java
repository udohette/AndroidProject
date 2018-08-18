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

public class Time extends AppCompatActivity {
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
        ArrayList<EfikPhrase> category_time = new ArrayList<EfikPhrase>();
        category_time.add(new EfikPhrase("1 O'Clock","ŋkanika Kiet"));
        category_time.add(new EfikPhrase("2 O'Clock","ŋkanika Iba"));
        category_time.add(new EfikPhrase("Afternoon","Uwemeyo"));
        category_time.add(new EfikPhrase("Day","Usen"));
        category_time.add(new EfikPhrase("DayLight","Uŋwana"));
        category_time.add(new EfikPhrase("Evening","Mbubreyo"));
        category_time.add(new EfikPhrase("Interval Between 1 And 2 O'Clock","Abe Kiet"));
        category_time.add(new EfikPhrase("Interval Between 1 And 3 O'Clock","Abe Iba"));
        category_time.add(new EfikPhrase("Month","ɔfiɔŋ"));
        category_time.add(new EfikPhrase("Morning","Usenubɔk"));
        category_time.add(new EfikPhrase("Night","Okoneyo"));
        category_time.add(new EfikPhrase("Today","Mfin"));
        category_time.add(new EfikPhrase("Week","Udua"));
        category_time.add(new EfikPhrase("Year","Isua"));
        category_time.add(new EfikPhrase("Yesterday","Edem Mkpɔŋ"));
        EfikeAdapter adapter = new EfikeAdapter(this,category_time,R.color.Category_Time);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
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
