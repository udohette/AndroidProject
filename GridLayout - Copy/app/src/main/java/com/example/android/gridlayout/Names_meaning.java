package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Names_meaning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> category_names_meaning = new ArrayList<EfikPhrase>();
        category_names_meaning.add(new EfikPhrase("My Life Is In God's Guard","Abasiakamauwemowot"));
        category_names_meaning.add(new EfikPhrase("God Love","Abasiama"));
        category_names_meaning.add(new EfikPhrase("God Never Forget","Abasi-Ifreke "));
        category_names_meaning.add(new EfikPhrase("God Bless","Abasiodiong"));
        category_names_meaning.add(new EfikPhrase("First Female Child","Adiaba"));
        category_names_meaning.add(new EfikPhrase("First Daughter","Adiaha"));
        category_names_meaning.add(new EfikPhrase("Fourth Born Son","Afiah"));
        category_names_meaning.add(new EfikPhrase("The Ultimate Gift ","Akakaneno "));
        category_names_meaning.add(new EfikPhrase("First Male Son","Akpan"));
        category_names_meaning.add(new EfikPhrase("The Love Of A Mother ","Amaeka "));
        category_names_meaning.add(new EfikPhrase("The Giver","Andino"));
        category_names_meaning.add(new EfikPhrase("Who Likes Somebody","Aniamaowo "));
        category_names_meaning.add(new EfikPhrase("Who Is Like God","Aniebietabasi"));
        category_names_meaning.add(new EfikPhrase("Who Is Greater Than God","Aniekanabas"));
        category_names_meaning.add(new EfikPhrase("Who Could You Compare(To God)","Anietie"));
        category_names_meaning.add(new EfikPhrase("God Understand's Best","Anwangabasi"));
        category_names_meaning.add(new EfikPhrase("Third Daughter","Anwa-nwa "));
        category_names_meaning.add(new EfikPhrase("Great God","Aquabasi "));
        category_names_meaning.add(new EfikPhrase("Abundance","Barasuene "));
        category_names_meaning.add(new EfikPhrase("Celebrate Love","Daraima"));

        EfikeAdapter adapter = new EfikeAdapter(this,category_names_meaning,R.color.Category_Time);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
