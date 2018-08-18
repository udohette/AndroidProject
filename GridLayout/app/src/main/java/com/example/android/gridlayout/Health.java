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

public class Health extends AppCompatActivity {
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
        ArrayList<EfikPhrase> health_category = new ArrayList<>();
        health_category.add(new EfikPhrase("Ailment; Sickness; Disease; Illness","Udɔŋɔ"));
        health_category.add(new EfikPhrase("Chill","Tuep"));
        health_category.add(new EfikPhrase("Cough","Ikɔŋ"));
        health_category.add(new EfikPhrase("Fever","Ufiop Idem"));
        health_category.add(new EfikPhrase("Headache","ŋkɔŋibuot"));
        health_category.add(new EfikPhrase("Hospital; Any Medical Establishment","Ufɔk Ibɔk"));
        health_category.add(new EfikPhrase("In Bad Health","Idiɔk Idem"));
        health_category.add(new EfikPhrase("In Good Health","ɔsɔŋ Idem; ɔyɔhɔ Idem"));
        health_category.add(new EfikPhrase("Is Sick; Unwell","ɔdɔŋɔ"));
        health_category.add(new EfikPhrase("Medicine","Ibɔk"));
        health_category.add(new EfikPhrase("Take Medicine","Da Ibɔk"));

        EfikeAdapter efikeAdapter = new EfikeAdapter(this,health_category,R.color.Category_Health);
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
