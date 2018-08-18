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

public class Meeting_People extends AppCompatActivity {
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
        ArrayList<EfikPhrase> category_meeting_peple = new ArrayList<EfikPhrase>();
        category_meeting_peple.add(new EfikPhrase("Elders; Adult","Ikpo Owo"));
        category_meeting_peple.add(new EfikPhrase("Friend","Ufan"));
        category_meeting_peple.add(new EfikPhrase("He/She Is My Friend","Enye Edi Ufan Mi"));
        category_meeting_peple.add(new EfikPhrase("Am a Nigerian","Ndi Owo Nigeria"));
        category_meeting_peple.add(new EfikPhrase("I am Called...","Ekot Mi...."));
        category_meeting_peple.add(new EfikPhrase("I Am From Nigeria","Nto Nigeria"));
        category_meeting_peple.add(new EfikPhrase("I Am Happy (Pleased) To See You","Enem Mi Esit Ndikut Fi"));
        category_meeting_peple.add(new EfikPhrase("I Am His/Her Friend","Ami Ndi Ufan Esie"));
        category_meeting_peple.add(new EfikPhrase("I Am In Marriage (Married)","Ndu Ke Ndɔ"));
        category_meeting_peple.add(new EfikPhrase("I Came Alone","ŋsaŋa Ikpɔŋ"));
        category_meeting_peple.add(new EfikPhrase("I Do Not Have A Husband","Nnyeneke Ebe"));
        category_meeting_peple.add(new EfikPhrase("I Do Not Have A Wife","Nnyeneke ŋwan"));
        category_meeting_peple.add(new EfikPhrase("I Have A Child","Meyene Eyen"));
        category_meeting_peple.add(new EfikPhrase("I Have A Wife","Meyene ŋwan"));
        category_meeting_peple.add(new EfikPhrase("I have Children","Meyene Nditɔ"));
        category_meeting_peple.add(new EfikPhrase("Important Person","Akamba Owo"));
        category_meeting_peple.add(new EfikPhrase("My Name Is....","Enyin Mi Edi...."));
        category_meeting_peple.add(new EfikPhrase("Old Person","Akani Owo"));
        category_meeting_peple.add(new EfikPhrase("Person","Owo"));
        category_meeting_peple.add(new EfikPhrase("Safe Journey","Saŋa Suŋ"));
        category_meeting_peple.add(new EfikPhrase("See You Later","Ka Di"));
        category_meeting_peple.add(new EfikPhrase("We will Meet There","Iyesobo Dot"));
        category_meeting_peple.add(new EfikPhrase("We will See","Iyekut"));
        category_meeting_peple.add(new EfikPhrase("What are You Called?","Nso Ke Ekot Fi?"));
        category_meeting_peple.add(new EfikPhrase("What Is Your Name?","Enyin Fo Edi Nso?; Ekere Nso?"));
        category_meeting_peple.add(new EfikPhrase("Where are You From?","Oto Mmɔŋ?"));
        category_meeting_peple.add(new EfikPhrase("Young Lady; Spinster","ŋkaiferi"));
        category_meeting_peple.add(new EfikPhrase("Young Man; Bachelor","Akparawa"));


        EfikeAdapter adapter = new EfikeAdapter(this,category_meeting_peple,R.color.Category_Meeting_People);
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
