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

public class Landscape extends AppCompatActivity {
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
        ArrayList<EfikPhrase> landscape = new ArrayList<EfikPhrase>();
        landscape.add(new EfikPhrase("Bush; Forest","Ikɔt"));
        landscape.add(new EfikPhrase("Garden; Farmland","Inwaŋ"));
        landscape.add(new EfikPhrase("Harbour; Coastline","Esuk"));
        landscape.add(new EfikPhrase("Hill; Mountain","Obot"));
        landscape.add(new EfikPhrase("Land; Ground","Isɔŋ"));
        landscape.add(new EfikPhrase("River; Sea; Ocean","Inyaŋ"));
        landscape.add(new EfikPhrase("Sand","Ntanisɔŋ"));
        landscape.add(new EfikPhrase("Stream","Idim"));
        landscape.add(new EfikPhrase("Tree","Eto"));
        landscape.add(new EfikPhrase("Valley","Itihere"));
        landscape.add(new EfikPhrase("Water","Mmɔŋ"));

        EfikeAdapter adapter = new EfikeAdapter(this,landscape,R.color.Category_Landscape);
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
