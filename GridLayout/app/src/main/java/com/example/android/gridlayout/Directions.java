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

public class Directions extends AppCompatActivity {
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
        ArrayList<EfikPhrase> directions = new ArrayList<>();
        directions.add(new EfikPhrase("Before,","Mbemiso"));
        directions.add(new EfikPhrase("Behind","Ke Edem"));
        directions.add(new EfikPhrase("End (Of The Road)","Akpatre"));
        directions.add(new EfikPhrase("Far; Distant","Oyom Usuŋ"));
        directions.add(new EfikPhrase("Front; Ahead","Iso"));
        directions.add(new EfikPhrase("Go","Ka"));
        directions.add(new EfikPhrase("Go Straight","Ka Nnen-Nnen"));
        directions.add(new EfikPhrase("Here; Over Here","Mi"));
        directions.add(new EfikPhrase("In Front","Ke Iso"));
        directions.add(new EfikPhrase("Left","Ufien"));
        directions.add(new EfikPhrase("Near","Ekpere"));
        directions.add(new EfikPhrase("Near Me,","kpere Mi"));
        directions.add(new EfikPhrase("Not Far,","Ekpere Usuŋ"));
        directions.add(new EfikPhrase("Over There; Yonder","Ko"));
        directions.add(new EfikPhrase("Pass Through; Via,","Saŋa Be"));
        directions.add(new EfikPhrase("Arrive;Reach,","Sim"));
        directions.add(new EfikPhrase("Ride; Drive","Wat"));
        directions.add(new EfikPhrase("Right","Nnasia"));
        directions.add(new EfikPhrase("Side","Mben"));
        directions.add(new EfikPhrase("Side Ways","Mben-Mben"));
        directions.add(new EfikPhrase("Stop; End","Tre"));
        directions.add(new EfikPhrase("Straight","Nnen-Nnen"));
        directions.add(new EfikPhrase("That Place","Itie Odo"));
        directions.add(new EfikPhrase("This Place","Itie Emi"));
        directions.add(new EfikPhrase("There","Do"));
        directions.add(new EfikPhrase("Turn","Wahade"));
        directions.add(new EfikPhrase("Turn Left","Wahahe Ke Ufien"));
        directions.add(new EfikPhrase("Turn Right","Wahade Ke Nnasia"));
        directions.add(new EfikPhrase("Turn There","Wahade Do"));
        directions.add(new EfikPhrase("Turn; Turn Back; U-turn","ŋwɔŋɔde"));
        EfikeAdapter adapter = new EfikeAdapter(this,directions,R.color.Category_Directions);
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
