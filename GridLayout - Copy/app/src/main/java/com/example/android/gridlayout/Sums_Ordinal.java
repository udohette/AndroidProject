package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Sums_Ordinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> category_sums_ordinal = new ArrayList<EfikPhrase>();
        category_sums_ordinal.add(new EfikPhrase("1st","Akpa"));
        category_sums_ordinal.add(new EfikPhrase("2nd","Udiana Akpa"));
        category_sums_ordinal.add(new EfikPhrase("3rd","ɔyɔhɔ Akpa Ita"));
        category_sums_ordinal.add(new EfikPhrase("4th","ɔyɔhɔ Akpa Inaŋ"));
        category_sums_ordinal.add(new EfikPhrase("Add","Dian"));
        category_sums_ordinal.add(new EfikPhrase("Count","Bat"));
        category_sums_ordinal.add(new EfikPhrase("Divide","Bahare"));
        category_sums_ordinal.add(new EfikPhrase("Equals","ɔwɔrɔ"));
        category_sums_ordinal.add(new EfikPhrase("How Many; How Much","Ifaŋ"));
        category_sums_ordinal.add(new EfikPhrase("Multiply","Tɔt"));
        category_sums_ordinal.add(new EfikPhrase("Plenty; Many","Ewak"));
        category_sums_ordinal.add(new EfikPhrase("Remove; Subtract","Sio"));



        EfikeAdapter adapter = new EfikeAdapter(this,category_sums_ordinal,R.color.Category_Sums_Ordinals);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
