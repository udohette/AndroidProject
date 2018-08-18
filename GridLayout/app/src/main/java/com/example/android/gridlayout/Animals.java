package com.example.android.gridlayout;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class Animals extends AppCompatActivity {
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

        ArrayList<EfikPhrase>animals = new ArrayList<EfikPhrase>();
        animals.add(new EfikPhrase("Animals","Unam Ikɔt"));
        animals.add(new EfikPhrase("Bird","Inuen"));
        animals.add(new EfikPhrase("Cat","Anwa"));
        animals.add(new EfikPhrase("Cattle","Ufene"));
        animals.add(new EfikPhrase("Chicken","Unen"));
        animals.add(new EfikPhrase("Cow","Enaŋ"));
        animals.add(new EfikPhrase("Dog","Ebua"));
        animals.add(new EfikPhrase("Female","Uman"));
        animals.add(new EfikPhrase("Fish","Iyak"));
        animals.add(new EfikPhrase("Goat","Ebot"));
        animals.add(new EfikPhrase("Lion","Ekpe"));
        animals.add(new EfikPhrase("Male","Ayara"));
        animals.add(new EfikPhrase("Python","Asabɔ"));
        animals.add(new EfikPhrase("Sheep","Erɔŋ"));
        animals.add(new EfikPhrase("Snake","Urukikot"));
        animals.add(new EfikPhrase("Tortoise","Ikut"));
        animals.add(new EfikPhrase("Meat","Unam"));
        EfikeAdapter adapter = new EfikeAdapter(this,animals,R.color.Category_Animals);
        ListView listView = (ListView)findViewById(R.id.list_view);
        assert listView != null;
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
