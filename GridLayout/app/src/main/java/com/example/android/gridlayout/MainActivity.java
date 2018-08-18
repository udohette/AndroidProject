package com.example.android.gridlayout;

import android.app.ActionBar;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

//        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
//        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
//        tabLayout.setupWithViewPager(viewPager);
//
//        // Create an adapter that knows which fragment should be shown on each page
//       SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this,getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
        GridView myGrid = (GridView) findViewById(R.id.gridView);
        if (myGrid != null) {
            myGrid.setAdapter(new EfikAdapter(this));
        }
        if (myGrid != null) {
            myGrid.setOnItemClickListener(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.main_activity_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchView).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);
        searchView.setSubmitButtonEnabled(true);
        setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.language_menu:
                Toast.makeText(getApplicationContext(), "Testing Language Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings_menu:
                Toast.makeText(getApplicationContext(), "Testing settings Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.imageGallery:
               Intent intent = new Intent(this, com.example.android.gridlayout.Gallery.class);
               startActivity(intent);
            /*case R.id.searchView:
                Log.d("Search","testing App");
                Intent intent = new Intent(this, FilterActivity.class);
                startActivity(intent);
                return true;*/

            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EfikPhrases phrase = (EfikPhrases) parent.getAdapter().getItem(position);
        int imageId = phrase.Images;
        if (imageId == R.drawable.color_black) {
            Intent intent = new Intent(MainActivity.this, Greetings_Etiquette.class);
            startActivity(intent);
        } else if (imageId == R.drawable.family_father) {
            Intent intent = new Intent(MainActivity.this, Animals.class);
            startActivity(intent);
        } else {
            if (imageId == R.drawable.color_green) {
                Intent intent = new Intent(MainActivity.this, Around_the_House.class);
                startActivity(intent);
            } else {
                if (imageId == R.drawable.number_three) {
                    Intent intent = new Intent(MainActivity.this, Clothing.class);
                    startActivity(intent);
                } else {
                    if (imageId == R.drawable.family_grandfather) {
                        Intent intent = new Intent(MainActivity.this, Colors.class);
                        startActivity(intent);
                    } else {
                        if (imageId == R.drawable.family_son) {
                            Intent intent = new Intent(MainActivity.this, Landscape.class);
                            startActivity(intent);
                        } else {
                            if (imageId == R.drawable.number_six) {
                                Intent intent = new Intent(MainActivity.this, Directions.class);
                                startActivity(intent);
                            } else {
                                if (imageId == R.drawable.color_red) {
                                    Intent intent = new Intent(MainActivity.this, Education.class);
                                    startActivity(intent);
                                } else {
                                    if (imageId == R.drawable.family_younger_sister) {
                                        Intent intent = new Intent(MainActivity.this, Food_and_Drink.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.color_gray) {
                                        Intent intent = new Intent(MainActivity.this, Meeting_People.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.family_older_brother) {
                                        Intent intent = new Intent(MainActivity.this, Religion.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.family_older_sister) {
                                        Intent intent = new Intent(MainActivity.this, Sums_Ordinal.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.color_dusty_yellow) {
                                        Intent intent = new Intent(MainActivity.this, Time.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.family_mother) {
                                        Intent intent = new Intent(MainActivity.this, Verbs_prounouns.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.color_white) {
                                        Intent intent = new Intent(MainActivity.this, Weather.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.number_seven) {
                                        Intent intent = new Intent(MainActivity.this, Shopping.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.number_ten) {
                                        Intent intent = new Intent(MainActivity.this, Human_anatomy.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.number_one) {
                                        Intent intent = new Intent(MainActivity.this, Numbers.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.number_five) {
                                        Intent intent = new Intent(MainActivity.this, Health.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.number_two) {
                                        Intent intent = new Intent(MainActivity.this, Names_meaning.class);
                                        startActivity(intent);
                                    }

                                }
                            }
                        }

                    }
                }
            }
        }
    }

}


