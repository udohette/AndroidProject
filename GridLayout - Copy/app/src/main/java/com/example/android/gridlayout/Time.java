package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Time extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> category_time = new ArrayList<EfikPhrase>();
        category_time.add(new EfikPhrase("1 O'Clock","ŋkanika Kiet"));
        category_time.add(new EfikPhrase("2 O'Clock","ŋkanika Iba"));
        category_time.add(new EfikPhrase("Afternoon","Uwemeyo"));
        category_time.add(new EfikPhrase("Day","Usen"));
        category_time.add(new EfikPhrase("DayLight","Uŋwana"));
        category_time.add(new EfikPhrase("Evening","Mbubreyo"));
        category_time.add(new EfikPhrase("Interval Between 1 And 2 O'Clock","Abe Kiet"));
        category_time.add(new EfikPhrase("Interval Between 1 And 3 O'Clock","Abe Iba"));
        category_time.add(new EfikPhrase("Month","ɔfiɔŋ"));
        category_time.add(new EfikPhrase("Morning","Usenubɔk"));
        category_time.add(new EfikPhrase("Night","Okoneyo"));
        category_time.add(new EfikPhrase("Today","Mfin"));
        category_time.add(new EfikPhrase("Week","Udua"));
        category_time.add(new EfikPhrase("Year","Isua"));
        category_time.add(new EfikPhrase("Yesterday","Edem Mkpɔŋ"));
        EfikeAdapter adapter = new EfikeAdapter(this,category_time,R.color.Category_Time);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
