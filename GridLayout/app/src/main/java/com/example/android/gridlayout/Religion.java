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

public class Religion extends AppCompatActivity {
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
        ArrayList<EfikPhrase> category_religion = new ArrayList<EfikPhrase>();
        category_religion.add(new EfikPhrase("Lord","ɔbɔŋ"));
        category_religion.add(new EfikPhrase("Sunday","Ederi"));
        category_religion.add(new EfikPhrase("Bless","Diɔŋ"));
        category_religion.add(new EfikPhrase("God","Abasi"));
        category_religion.add(new EfikPhrase("Holy Book(Bible)","ŋwed Abasi"));
        category_religion.add(new EfikPhrase("Song; Hymn","Ikwɔ"));
        category_religion.add(new EfikPhrase("Pray","Bɔŋ Akam"));
        category_religion.add(new EfikPhrase("Prayer","Akam"));
        category_religion.add(new EfikPhrase("Preacher","ɔkwɔrɔ Ikɔ"));
        category_religion.add(new EfikPhrase("Religious Person(Christian)","Owo Abasi"));
        category_religion.add(new EfikPhrase("Scriptures","Ikɔ Abasi"));

        EfikeAdapter adapter = new EfikeAdapter(this,category_religion,R.color.Category_Religion);
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
