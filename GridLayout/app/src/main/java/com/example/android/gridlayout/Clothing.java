package com.example.android.gridlayout;

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

public class Clothing extends AppCompatActivity {
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
        ArrayList<EfikPhrase> clothing = new ArrayList<>();
        clothing.add(new EfikPhrase("Clothing","ɔfɔŋ"));
        clothing.add(new EfikPhrase("Dress; Gown","Ewara"));
        clothing.add(new EfikPhrase("Hat; Cap","Itam"));
        clothing.add(new EfikPhrase("Loin Cloth; Wrapper","ɔfɔŋ Isin"));
        clothing.add(new EfikPhrase("Shoes","Ikpɔ Ukot"));
        clothing.add(new EfikPhrase("Shorts","Ekpri ɔfɔŋ Ukot; Ibio ɔfɔŋ Ukot"));
        clothing.add(new EfikPhrase("Trouser","ɔfɔŋ Ukot"));
        clothing.add(new EfikPhrase("Underwear","Iba"));
        clothing.add(new EfikPhrase("Wear Clothes","Sine ɔfɔŋ"));
        EfikeAdapter adapter = new EfikeAdapter(this,clothing,R.color.Category_Clothing);
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
