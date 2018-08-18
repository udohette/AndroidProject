package com.example.android.efikphrase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Landscape extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> landscape = new ArrayList<EfikPhrase>();
        landscape.add(new EfikPhrase("Bush; Forest","Ikɔt"));
        landscape.add(new EfikPhrase("Garden; Farmland","Inwaŋ"));
        landscape.add(new EfikPhrase("Harbour; Coastline","Esuk"));
        landscape.add(new EfikPhrase("Hill; Mountain","Obot"));
        landscape.add(new EfikPhrase("Land; Ground","Isɔŋ"));
        landscape.add(new EfikPhrase("River; Sea; Ocean","Inyaŋ"));
        landscape.add(new EfikPhrase("Sand","Ntanisɔŋ"));
        landscape.add(new EfikPhrase("Stream","Idim"));
        landscape.add(new EfikPhrase("Tree","Eto"));
        landscape.add(new EfikPhrase("Valley","Itihere"));
        landscape.add(new EfikPhrase("Water","Mmɔŋ"));

        EfikeAdapter adapter = new EfikeAdapter(this,landscape,R.color.Category_Landscape);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
