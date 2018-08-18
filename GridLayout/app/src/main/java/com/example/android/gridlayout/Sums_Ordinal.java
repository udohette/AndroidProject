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

public class Sums_Ordinal extends AppCompatActivity {
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
        ArrayList<EfikPhrase> category_sums_ordinal = new ArrayList<EfikPhrase>();
        category_sums_ordinal.add(new EfikPhrase("1st","Akpa"));
        category_sums_ordinal.add(new EfikPhrase("2nd","Udiana Akpa"));
        category_sums_ordinal.add(new EfikPhrase("3rd","ɔyɔhɔ Akpa Ita"));
        category_sums_ordinal.add(new EfikPhrase("4th","ɔyɔhɔ Akpa Inaŋ"));
        category_sums_ordinal.add(new EfikPhrase("Add","Dian"));
        category_sums_ordinal.add(new EfikPhrase("Count","Bat"));
        category_sums_ordinal.add(new EfikPhrase("Divide","Bahare"));
        category_sums_ordinal.add(new EfikPhrase("Equals","ɔwɔrɔ"));
        category_sums_ordinal.add(new EfikPhrase("How Many; How Much","Ifaŋ"));
        category_sums_ordinal.add(new EfikPhrase("Multiply","Tɔt"));
        category_sums_ordinal.add(new EfikPhrase("Plenty; Many","Ewak"));
        category_sums_ordinal.add(new EfikPhrase("Remove; Subtract","Sio"));



        EfikeAdapter adapter = new EfikeAdapter(this,category_sums_ordinal,R.color.Category_Sums_Ordinals);
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
