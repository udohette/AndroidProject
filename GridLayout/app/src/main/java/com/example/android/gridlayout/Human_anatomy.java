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

public class Human_anatomy extends AppCompatActivity {
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
        ArrayList<EfikPhrase> category_human_anatomy = new ArrayList<EfikPhrase>();
        category_human_anatomy.add(new EfikPhrase("Back","Edem"));
        category_human_anatomy.add(new EfikPhrase("Body","Idem"));
        category_human_anatomy.add(new EfikPhrase("Bone","ɔkpɔ"));
        category_human_anatomy.add(new EfikPhrase("Breast","Eba"));
        category_human_anatomy.add(new EfikPhrase("Ear","Utɔŋ"));
        category_human_anatomy.add(new EfikPhrase("Eyes","Enyin"));
        category_human_anatomy.add(new EfikPhrase("Finger-Nails","Mbara-Ubɔk"));
        category_human_anatomy.add(new EfikPhrase("Flesh","Ikpɔk Idem"));
        category_human_anatomy.add(new EfikPhrase("Foot Or leg","Ukot"));
        category_human_anatomy.add(new EfikPhrase("Hair","Idet"));
        category_human_anatomy.add(new EfikPhrase("Hand Or Arm","Ubɔk"));
        category_human_anatomy.add(new EfikPhrase("Head","Ibuot"));
        category_human_anatomy.add(new EfikPhrase("Heart; Liver; Chest","Esit"));
        category_human_anatomy.add(new EfikPhrase("Intestine","ŋsia"));
        category_human_anatomy.add(new EfikPhrase("Knee","Erɔŋ"));
        category_human_anatomy.add(new EfikPhrase("Mouth","Inua"));
        category_human_anatomy.add(new EfikPhrase("Neck","Itɔŋ"));
        category_human_anatomy.add(new EfikPhrase("Nose","Ibuo"));
        category_human_anatomy.add(new EfikPhrase("Rib","ɔkpɔ-ŋkaŋ"));
        category_human_anatomy.add(new EfikPhrase("Shoulder","Afara"));
        category_human_anatomy.add(new EfikPhrase("Sole Of Feet","ŋditiŋ-Ikpat"));
        category_human_anatomy.add(new EfikPhrase("Stomach","Idib"));
        category_human_anatomy.add(new EfikPhrase("Toenails","Mbara-Ukot"));
        category_human_anatomy.add(new EfikPhrase("Tongue","Edeme"));
        category_human_anatomy.add(new EfikPhrase("Teeth","Edet"));

        EfikeAdapter adapter = new EfikeAdapter(this,category_human_anatomy,R.color.Category_Human_Anatomy);
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
