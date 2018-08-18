package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Meeting_People extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> category_meeting_peple = new ArrayList<EfikPhrase>();
        category_meeting_peple.add(new EfikPhrase("Elders; Adult","Ikpo Owo"));
        category_meeting_peple.add(new EfikPhrase("Friend","Ufan"));
        category_meeting_peple.add(new EfikPhrase("He/She Is My Friend","Enye Edi Ufan Mi"));
        category_meeting_peple.add(new EfikPhrase("Am a Nigerian","Ndi Owo Nigeria"));
        category_meeting_peple.add(new EfikPhrase("I am Called...","Ekot Mi...."));
        category_meeting_peple.add(new EfikPhrase("I Am From Nigeria","Nto Nigeria"));
        category_meeting_peple.add(new EfikPhrase("I Am Happy (Pleased) To See You","Enem Mi Esit Ndikut Fi"));
        category_meeting_peple.add(new EfikPhrase("I Am His/Her Friend","Ami Ndi Ufan Esie"));
        category_meeting_peple.add(new EfikPhrase("I Am In Marriage (Married)","Ndu Ke Ndɔ"));
        category_meeting_peple.add(new EfikPhrase("I Came Alone","ŋsaŋa Ikpɔŋ"));
        category_meeting_peple.add(new EfikPhrase("I Do Not Have A Husband","Nnyeneke Ebe"));
        category_meeting_peple.add(new EfikPhrase("I Do Not Have A Wife","Nnyeneke ŋwan"));
        category_meeting_peple.add(new EfikPhrase("I Have A Child","Meyene Eyen"));
        category_meeting_peple.add(new EfikPhrase("I Have A Wife","Meyene ŋwan"));
        category_meeting_peple.add(new EfikPhrase("I have Children","Meyene Nditɔ"));
        category_meeting_peple.add(new EfikPhrase("Important Person","Akamba Owo"));
        category_meeting_peple.add(new EfikPhrase("My Name Is....","Enyin Mi Edi...."));
        category_meeting_peple.add(new EfikPhrase("Old Person","Akani Owo"));
        category_meeting_peple.add(new EfikPhrase("Person","Owo"));
        category_meeting_peple.add(new EfikPhrase("Safe Journey","Saŋa Suŋ"));
        category_meeting_peple.add(new EfikPhrase("See You Later","Ka Di"));
        category_meeting_peple.add(new EfikPhrase("We will Meet There","Iyesobo Dot"));
        category_meeting_peple.add(new EfikPhrase("We will See","Iyekut"));
        category_meeting_peple.add(new EfikPhrase("What are You Called?","Nso Ke Ekot Fi?"));
        category_meeting_peple.add(new EfikPhrase("What Is Your Name?","Enyin Fo Edi Nso?; Ekere Nso?"));
        category_meeting_peple.add(new EfikPhrase("Where are You From?","Oto Mmɔŋ?"));
        category_meeting_peple.add(new EfikPhrase("Young Lady; Spinster","ŋkaiferi"));
        category_meeting_peple.add(new EfikPhrase("Young Man; Bachelor","Akparawa"));


        EfikeAdapter adapter = new EfikeAdapter(this,category_meeting_peple,R.color.Category_Meeting_People);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
