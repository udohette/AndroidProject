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

public class Around_the_House extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

            ArrayList<EfikPhrase> around_House = new ArrayList<>();
            around_House.add(new EfikPhrase("Back Door", "Usuŋ Edem Ufɔk"));
            around_House.add(new EfikPhrase("Backyard; Bathroom", "Esa"));
            around_House.add(new EfikPhrase("Brick Or Concrete Building", "Ufɔk Itiat"));
            around_House.add(new EfikPhrase("Chair", "Akpakaha"));
            around_House.add(new EfikPhrase("Floor", "Isɔŋ"));
            around_House.add(new EfikPhrase("Front Door", "Enyin Usuŋ Ufɔk"));
            around_House.add(new EfikPhrase("Have a Shower/Bath", "Yere Mmɔŋ"));
            around_House.add(new EfikPhrase("House; Home; Any Building", "Ufɔk"));
            around_House.add(new EfikPhrase("I Am In The Backyard", "Ndu Ke Esa"));
            around_House.add(new EfikPhrase("Lounge", "Ufot Ufɔk"));
            around_House.add(new EfikPhrase("Out Side", "Aŋwa"));
            around_House.add(new EfikPhrase("Roof", "ɔkɔm"));
            around_House.add(new EfikPhrase("Room", "Ubet"));
            around_House.add(new EfikPhrase("Seat; Bed", "Akwaŋ"));
            around_House.add(new EfikPhrase("Side Door", "ŋkaŋ Usuŋ Ufɔk"));
            around_House.add(new EfikPhrase("Soup", "Suɔp"));
            around_House.add(new EfikPhrase("Sponge", "Kusa"));
            around_House.add(new EfikPhrase("Table", "Okpokoro"));
            around_House.add(new EfikPhrase("Thatch", "Nkaya"));
            around_House.add(new EfikPhrase("Use Backyard", "UKa Esa"));
            around_House.add(new EfikPhrase("Wash", "Yet"));
            around_House.add(new EfikPhrase("Window", "Ekpri Usuŋ"));
            EfikeAdapter adapter = new EfikeAdapter(this, around_House, R.color.Category_Around_The_House);
            ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(adapter);
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
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
        public boolean onOptionsItemSelected (MenuItem item){
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
