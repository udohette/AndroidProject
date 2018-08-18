package com.example.android.gridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Greetings_Etiquette extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> greeting_Eti = new ArrayList<EfikPhrase>();
        greeting_Eti.add(new EfikPhrase("Good Bye","Tie Suŋ"));
        greeting_Eti.add(new EfikPhrase("Good Morning","Emesiere"));
        greeting_Eti.add(new EfikPhrase("Good Morning(Response)","Emesiere Nde"));
        greeting_Eti.add(new EfikPhrase("Good Night","Esiere"));
        greeting_Eti.add(new EfikPhrase("Good Night(Response)","Esiere Nde"));
        greeting_Eti.add(new EfikPhrase("Hello/Good Afternoon","Mɔkɔm"));
        greeting_Eti.add(new EfikPhrase("How are You?","Idem Fo?"));
        greeting_Eti.add(new EfikPhrase("How Is It With You?","Etie Didie?"));
        greeting_Eti.add(new EfikPhrase("I am Well","Idem Mi ɔsɔŋ"));
        greeting_Eti.add(new EfikPhrase("Please","Mbɔk"));
        greeting_Eti.add(new EfikPhrase("Thank You","Sɔsɔŋɔ"));
        greeting_Eti.add(new EfikPhrase("Thank You (Very Much","Sɔsɔŋɔ (Eti Eti)"));
        greeting_Eti.add(new EfikPhrase("Welcome","Emedi"));

        EfikeAdapter adapter = new EfikeAdapter(this,greeting_Eti,R.color.Category_GreetingsEtiquette);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
