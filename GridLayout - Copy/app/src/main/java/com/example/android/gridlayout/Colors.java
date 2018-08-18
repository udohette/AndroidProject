package com.example.android.gridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase>color_category = new ArrayList<EfikPhrase>();
        color_category.add(new EfikPhrase("Red","Ndat Ndat"));
        color_category.add(new EfikPhrase("Black","Obubit"));
        color_category.add(new EfikPhrase("White","Afia"));
        color_category.add(new EfikPhrase("Green","Awawa"));

        EfikeAdapter adapter = new EfikeAdapter(this,color_category,R.color.Category_Colours);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        }
    }

