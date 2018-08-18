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
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.ArrayMap;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
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

        //Set a Click Listener on that View;
        numbers.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the number category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new Intent to open the @NumbersActivity
                Intent numberIntent = new Intent(MainActivity.this,NumbersActitvity.class);
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
                Intent familyIntent = new Intent(MainActivity.this,FamilyActivity.class);
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
                Intent colorIntent = new Intent(MainActivity.this, ColorsAcitivity.class);
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
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesIntent);

            }
        });
    }}

