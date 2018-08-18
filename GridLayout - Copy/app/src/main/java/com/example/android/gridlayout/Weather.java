package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Weather extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> category_weather = new ArrayList<EfikPhrase>();
        category_weather.add(new EfikPhrase("Cloud","Idiɔk Enyɔŋ"));
        category_weather.add(new EfikPhrase("Dry","Asat"));
        category_weather.add(new EfikPhrase("Hot; Worm","Ofiop"));
        category_weather.add(new EfikPhrase("It Is Sunny","Eyo Ke Ada"));
        category_weather.add(new EfikPhrase("Moon","ɔfiɔŋ"));
        category_weather.add(new EfikPhrase("Rain","Edim"));
        category_weather.add(new EfikPhrase("Rains A Lot","Edim Eti Eti"));
        category_weather.add(new EfikPhrase("Sky","Enyɔŋ"));
        category_weather.add(new EfikPhrase("Stars","ŋtantaɔfiɔŋ"));
        category_weather.add(new EfikPhrase("Sun","Utin"));
        category_weather.add(new EfikPhrase("Sunshine","Ndaeyo"));
        category_weather.add(new EfikPhrase("Thunder","Obuma"));
        category_weather.add(new EfikPhrase("Weather","Eyo"));
        category_weather.add(new EfikPhrase("Wet","Mbit Mbit"));
        category_weather.add(new EfikPhrase("Wind","Ofim"));
        category_weather.add(new EfikPhrase("Windy","Ofime"));

        EfikeAdapter adapter = new EfikeAdapter(this,category_weather,R.color.Category_Weather);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
