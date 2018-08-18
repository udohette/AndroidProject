/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.ArrayMap;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabWidget;
import android.widget.TextView;
import android.os.UserHandle;
import android.view.View.OnClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        // Find the view that shows the Numbers Category;
        TextView numbers = (TextView) findViewById(R.id.numbers);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this,getSupportFragmentManager());
        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

        //Set a Click Listener on that View;
        numbers.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the number category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new Intent to open the @NumbersActivity
                Intent numberIntent = new Intent(MainActivity.this,NumbersFragment.class);
                //Start the new Activity
                startActivity(numberIntent);

        }

    });
        // Find the view that shows the Family Members Category;
        TextView familyMembers = (TextView) findViewById(R.id.family);
        familyMembers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new Intent to open the @FamilyActivity
                Intent familyIntent = new Intent(MainActivity.this,FamilyFragment.class);
                //Start the new Activity
                startActivity(familyIntent);

            }
        });
        // Find the view that shows the Colors Category;
        TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new Intent to open the @ColorActivity
                Intent colorIntent = new Intent(MainActivity.this, ColorFragment.class);
                //Start the new Activity
                startActivity(colorIntent);

            }
        });
        // Find the view that shows the Phrases Category;
        TextView phrases = (TextView)findViewById(R.id.phrases);
        phrases.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new Intent to open the @ColorActivity
                Intent phrasesIntent = new Intent(MainActivity.this, PhraseFragment.class);
                startActivity(phrasesIntent);

            }
        });
    }}

