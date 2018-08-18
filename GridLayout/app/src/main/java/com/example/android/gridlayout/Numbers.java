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

public class Numbers extends AppCompatActivity {
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
        ArrayList<EfikPhrase> category_numbers = new ArrayList<EfikPhrase>();
        category_numbers.add(new EfikPhrase("1","Kiet"));
        category_numbers.add(new EfikPhrase("2","Iba"));
        category_numbers.add(new EfikPhrase("3","Ita"));
        category_numbers.add(new EfikPhrase("4","Inaŋ"));
        category_numbers.add(new EfikPhrase("5","Ition"));
        category_numbers.add(new EfikPhrase("6","Itiokiet"));
        category_numbers.add(new EfikPhrase("7","Itiaba"));
        category_numbers.add(new EfikPhrase("8","Itiaita"));
        category_numbers.add(new EfikPhrase("9","Usukkiet"));
        category_numbers.add(new EfikPhrase("10","Duop"));
        category_numbers.add(new EfikPhrase("11","Duopekiet"));
        category_numbers.add(new EfikPhrase("12","Duopeba"));
        category_numbers.add(new EfikPhrase("13","Duopeta"));
        category_numbers.add(new EfikPhrase("14","Duopenaŋ"));
        category_numbers.add(new EfikPhrase("15","Efut"));
        category_numbers.add(new EfikPhrase("16","Efutkiet"));
        category_numbers.add(new EfikPhrase("17","Efureba"));
        category_numbers.add(new EfikPhrase("18","Efureta"));
        category_numbers.add(new EfikPhrase("19","Efurenaŋ"));
        category_numbers.add(new EfikPhrase("20","Edip"));
        category_numbers.add(new EfikPhrase("21","Edip Ye Kiet"));
        category_numbers.add(new EfikPhrase("22","Edip Ye Iba"));
        category_numbers.add(new EfikPhrase("23","Edip Ye Ita"));
        category_numbers.add(new EfikPhrase("24","Edip Ye Inaŋ"));
        category_numbers.add(new EfikPhrase("25","Edip Ye Ition"));
        category_numbers.add(new EfikPhrase("26","Edip Ye Itiokiet"));
        category_numbers.add(new EfikPhrase("27","Edip Ye Itiaba"));
        category_numbers.add(new EfikPhrase("28","Edip Ye Itiaita"));
        category_numbers.add(new EfikPhrase("29","Edip Ye Inaŋ"));
        category_numbers.add(new EfikPhrase("30","Edip Ye Duop"));
        category_numbers.add(new EfikPhrase("31","Edip Ye Duopkiet"));
        category_numbers.add(new EfikPhrase("32","Edip Ye Duopeba"));
        category_numbers.add(new EfikPhrase("33","Edip Ye Duopeta"));
        category_numbers.add(new EfikPhrase("34","Edip Ye Duopenaŋ"));
        category_numbers.add(new EfikPhrase("35","Edip Ye Efut"));
        category_numbers.add(new EfikPhrase("36","Edip Ye Efutkiet"));
        category_numbers.add(new EfikPhrase("37","Edip Ye Efureba"));
        category_numbers.add(new EfikPhrase("38","Edip Ye Efureta"));
        category_numbers.add(new EfikPhrase("39","Edip Ye Efurenaŋ"));
        category_numbers.add(new EfikPhrase("40","Aba"));
        category_numbers.add(new EfikPhrase("50","Aba Ye Duop"));
        category_numbers.add(new EfikPhrase("60","Ata"));
        category_numbers.add(new EfikPhrase("70","Ata Ye Duop"));
        category_numbers.add(new EfikPhrase("80","Anaŋ"));
        category_numbers.add(new EfikPhrase("90","Anaŋ Ye Duop"));
        category_numbers.add(new EfikPhrase("100","Ikie"));
        category_numbers.add(new EfikPhrase("101","Ikie Ye Kiet"));
        category_numbers.add(new EfikPhrase("110","Ikie Ye Duop"));
        category_numbers.add(new EfikPhrase("112","Ikie Ye Duopeba"));
        category_numbers.add(new EfikPhrase("120","Ikie Ye Edip"));
        category_numbers.add(new EfikPhrase("150","Ikie Ye Aba Ye Duop"));
        category_numbers.add(new EfikPhrase("200","Ikie Iba"));
        category_numbers.add(new EfikPhrase("300","Ikie Ita"));
        category_numbers.add(new EfikPhrase("400","Ikie Inaŋ"));
        category_numbers.add(new EfikPhrase("500","Ikie Ition"));
        category_numbers.add(new EfikPhrase("600","Ikie Itiokiet"));
        category_numbers.add(new EfikPhrase("700","Ikie Itiaba"));
        category_numbers.add(new EfikPhrase("800","Ikie Itiaita"));
        category_numbers.add(new EfikPhrase("900","IIkie Usukiet"));
        category_numbers.add(new EfikPhrase("1000","Tɔsin"));

        EfikeAdapter adapter = new EfikeAdapter(this,category_numbers,R.color.Category_Numbers);
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
