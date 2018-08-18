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

public class Names_meaning extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        toolbar =(Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ArrayList<EfikPhrase> category_names_meaning = new ArrayList<EfikPhrase>();
        category_names_meaning.add(new EfikPhrase("My Life Is In God's Guard","Abasiakamauwemowot"));
        category_names_meaning.add(new EfikPhrase("God Love","Abasiama"));
        category_names_meaning.add(new EfikPhrase("God Never Forget","Abasi-Ifreke "));
        category_names_meaning.add(new EfikPhrase("God Bless","Abasiodiong"));
        category_names_meaning.add(new EfikPhrase("First Female Child","Adiaba"));
        category_names_meaning.add(new EfikPhrase("First Daughter","Adiaha"));
        category_names_meaning.add(new EfikPhrase("Fourth Born Son","Afiah"));
        category_names_meaning.add(new EfikPhrase("The Ultimate Gift ","Akakaneno "));
        category_names_meaning.add(new EfikPhrase("First Male Son","Akpan"));
        category_names_meaning.add(new EfikPhrase("The Love Of A Mother ","Amaeka "));
        category_names_meaning.add(new EfikPhrase("The Giver","Andino"));
        category_names_meaning.add(new EfikPhrase("Who Likes Somebody","Aniamaowo "));
        category_names_meaning.add(new EfikPhrase("Who Is Like God","Aniebietabasi"));
        category_names_meaning.add(new EfikPhrase("Who Is Greater Than God","Aniekanabas"));
        category_names_meaning.add(new EfikPhrase("Who Could You Compare(To God)","Anietie"));
        category_names_meaning.add(new EfikPhrase("God Understand's Best","Anwangabasi"));
        category_names_meaning.add(new EfikPhrase("Third Daughter","Anwa-nwa "));
        category_names_meaning.add(new EfikPhrase("Great God","Aquabasi "));
        category_names_meaning.add(new EfikPhrase("Abundance","Barasuene "));
        category_names_meaning.add(new EfikPhrase("Celebrate Love","Daraima"));

        EfikeAdapter adapter = new EfikeAdapter(this,category_names_meaning,R.color.Category_Time);
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
