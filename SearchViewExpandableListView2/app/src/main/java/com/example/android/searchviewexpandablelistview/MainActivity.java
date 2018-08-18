package com.example.android.searchviewexpandablelistview;

import android.app.SearchManager;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    private SearchManager searchManager;
    private MyExpandableListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<Parent_Row> parentList = new ArrayList<Parent_Row>();
    private ArrayList<Parent_Row> showThisParentList = new ArrayList<Parent_Row>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        parentList = new ArrayList<Parent_Row>();
        showThisParentList = new ArrayList<Parent_Row>();
    }

    private void loadData() {
        ArrayList<Child_Row> childRows = new ArrayList<Child_Row>();
        Parent_Row parentRow = null;
        childRows.add(new Child_Row(android.R.mipmap.sym_def_app_icon, "Search bar Implementation"));
        childRows.add(new Child_Row(android.R.mipmap.sym_def_app_icon, "Search your app Content"));
        parentRow = new Parent_Row("First Group", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<Child_Row>();
        childRows.add(new Child_Row(android.R.mipmap.sym_def_app_icon, "Jasper is the name of my Dog"));
        childRows.add(new Child_Row(android.R.mipmap.sym_def_app_icon, "Add Two plus Two"));
        parentRow = new Parent_Row("second Group", childRows);
        parentList.add(parentRow);
    }

    // this app will crash if display list is not called here
    private void displayList() {
        loadData();
        myList = (ExpandableListView) findViewById(R.id.expandableListView_Search);
        listAdapter = new MyExpandableListAdapter(MainActivity.this, parentList);
        myList.setAdapter(listAdapter);

    }

    //this expand the list of continents
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
            //end for (int i = 0;i <count;i++)
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the Menu; this add items to the action if present;
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();
        return true;
    }

    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filterData(newText);
        expandAll();
        return false;
    }
}
