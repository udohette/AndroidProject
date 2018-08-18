package com.example.android.gridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Animals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase>animals = new ArrayList<EfikPhrase>();
        animals.add(new EfikPhrase("Animals","Unam Ikɔt"));
        animals.add(new EfikPhrase("Bird","Inuen"));
        animals.add(new EfikPhrase("Cat","Anwa"));
        animals.add(new EfikPhrase("Cattle","Ufene"));
        animals.add(new EfikPhrase("Chicken","Unen"));
        animals.add(new EfikPhrase("Cow","Enaŋ"));
        animals.add(new EfikPhrase("Dog","Ebua"));
        animals.add(new EfikPhrase("Female","Uman"));
        animals.add(new EfikPhrase("Fish","Iyak"));
        animals.add(new EfikPhrase("Goat","Ebot"));
        animals.add(new EfikPhrase("Lion","Ekpe"));
        animals.add(new EfikPhrase("Male","Ayara"));
        animals.add(new EfikPhrase("Python","Asabɔ"));
        animals.add(new EfikPhrase("Sheep","Erɔŋ"));
        animals.add(new EfikPhrase("Snake","Urukikot"));
        animals.add(new EfikPhrase("Tortoise","Ikut"));
        EfikeAdapter adapter = new EfikeAdapter(this,animals,R.color.Category_Animals);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
