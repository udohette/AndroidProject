package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Religion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> category_religion = new ArrayList<EfikPhrase>();
        category_religion.add(new EfikPhrase("Lord","ɔbɔŋ"));
        category_religion.add(new EfikPhrase("Sunday","Ederi"));
        category_religion.add(new EfikPhrase("Bless","Diɔŋ"));
        category_religion.add(new EfikPhrase("God","Abasi"));
        category_religion.add(new EfikPhrase("Holy Book(Bible)","ŋwed Abasi"));
        category_religion.add(new EfikPhrase("Song; Hymn","Ikwɔ"));
        category_religion.add(new EfikPhrase("Pray","Bɔŋ Akam"));
        category_religion.add(new EfikPhrase("Prayer","Akam"));
        category_religion.add(new EfikPhrase("Preacher","ɔkwɔrɔ Ikɔ"));
        category_religion.add(new EfikPhrase("Religious Person(Christian)","Owo Abasi"));
        category_religion.add(new EfikPhrase("Scriptures","Ikɔ Abasi"));

        EfikeAdapter adapter = new EfikeAdapter(this,category_religion,R.color.Category_Religion);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
