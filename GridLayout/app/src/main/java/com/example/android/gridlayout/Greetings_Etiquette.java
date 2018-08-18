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

public class Greetings_Etiquette extends AppCompatActivity {
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
        ArrayList<EfikPhrase> greeting_Eti = new ArrayList<EfikPhrase>();
        greeting_Eti.add(new EfikPhrase("Good Bye","Tie Suŋ"));
        greeting_Eti.add(new EfikPhrase("Good Morning","Emesiere"));
        greeting_Eti.add(new EfikPhrase("Good Morning(Response)","Emesiere Nde"));
        greeting_Eti.add(new EfikPhrase("Good Night","Esiere"));
        greeting_Eti.add(new EfikPhrase("Good Night(Response)","Esiere Nde"));
        greeting_Eti.add(new EfikPhrase("Hello/Good Afternoon","Mɔkɔm"));
        greeting_Eti.add(new EfikPhrase("How are You?","Idem Fo?"));
        greeting_Eti.add(new EfikPhrase("How Is It With You?","Etie Didie?"));
        greeting_Eti.add(new EfikPhrase("I am Well","Idem Mi ɔsɔŋ"));
        greeting_Eti.add(new EfikPhrase("Please","Mbɔk"));
        greeting_Eti.add(new EfikPhrase("Thank You","Sɔsɔŋɔ"));
        greeting_Eti.add(new EfikPhrase("Thank You (Very Much","Sɔsɔŋɔ (Eti Eti)"));
        greeting_Eti.add(new EfikPhrase("Welcome","Emedi"));

        EfikeAdapter adapter = new EfikeAdapter(this,greeting_Eti,R.color.Category_GreetingsEtiquette);
        ListView listView = (ListView)findViewById(R.id.list_view);
        if (listView != null) {
            listView.setAdapter(adapter);
        }
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
