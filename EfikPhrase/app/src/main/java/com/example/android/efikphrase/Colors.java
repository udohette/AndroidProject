package com.example.android.efikphrase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase>color_category = new ArrayList<EfikPhrase>();
        color_category.add(new EfikPhrase("Red","Ndat Ndat",R.drawable.color_red));
        color_category.add(new EfikPhrase("Black","Obubit",R.drawable.color_black));
        color_category.add(new EfikPhrase("White","Afia",R.drawable.color_white));
        color_category.add(new EfikPhrase("Green","Awawa",R.drawable.color_green));

        EfikeAdapter adapter = new EfikeAdapter(this,color_category,R.color.Category_Colours);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        }
    }

