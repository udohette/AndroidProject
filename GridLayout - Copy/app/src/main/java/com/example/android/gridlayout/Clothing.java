package com.example.android.gridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Clothing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> clothing = new ArrayList<>();
        clothing.add(new EfikPhrase("Clothing","ɔfɔŋ"));
        clothing.add(new EfikPhrase("Dress; Gown","Ewara"));
        clothing.add(new EfikPhrase("Hat; Cap","Itam"));
        clothing.add(new EfikPhrase("Loin Cloth; Wrapper","ɔfɔŋ Isin"));
        clothing.add(new EfikPhrase("Shoes","Ikpɔ Ukot"));
        clothing.add(new EfikPhrase("Shorts","Ekpri ɔfɔŋ Ukot; Ibio ɔfɔŋ Ukot"));
        clothing.add(new EfikPhrase("Trouser","ɔfɔŋ Ukot"));
        clothing.add(new EfikPhrase("Underwear","Iba"));
        clothing.add(new EfikPhrase("Wear Clothes","Sine ɔfɔŋ"));
        EfikeAdapter adapter = new EfikeAdapter(this,clothing,R.color.Category_Clothing);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }
}
