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

public class Weather extends AppCompatActivity {
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

        ArrayList<EfikPhrase> category_weather = new ArrayList<EfikPhrase>();
        category_weather.add(new EfikPhrase("Cloud","Idiɔk Enyɔŋ"));
        category_weather.add(new EfikPhrase("Dry","Asat"));
        category_weather.add(new EfikPhrase("Hot; Worm","Ofiop"));
        category_weather.add(new EfikPhrase("It Is Sunny","Eyo Ke Ada"));
        category_weather.add(new EfikPhrase("Moon","ɔfiɔŋ"));
        category_weather.add(new EfikPhrase("Rain","Edim"));
        category_weather.add(new EfikPhrase("Rains A Lot","Edim Eti Eti"));
        category_weather.add(new EfikPhrase("Sky","Enyɔŋ"));
        category_weather.add(new EfikPhrase("Stars","ŋtantaɔfiɔŋ"));
        category_weather.add(new EfikPhrase("Sun","Utin"));
        category_weather.add(new EfikPhrase("Sunshine","Ndaeyo"));
        category_weather.add(new EfikPhrase("Thunder","Obuma"));
        category_weather.add(new EfikPhrase("Weather","Eyo"));
        category_weather.add(new EfikPhrase("Wet","Mbit Mbit"));
        category_weather.add(new EfikPhrase("Wind","Ofim"));
        category_weather.add(new EfikPhrase("Windy","Ofime"));

        EfikeAdapter adapter = new EfikeAdapter(this,category_weather,R.color.Category_Weather);
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
