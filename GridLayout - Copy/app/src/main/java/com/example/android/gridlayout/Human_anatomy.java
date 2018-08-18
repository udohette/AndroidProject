package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Human_anatomy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> category_human_anatomy = new ArrayList<EfikPhrase>();
        category_human_anatomy.add(new EfikPhrase("Back","Edem"));
        category_human_anatomy.add(new EfikPhrase("Body","Idem"));
        category_human_anatomy.add(new EfikPhrase("Bone","ɔkpɔ"));
        category_human_anatomy.add(new EfikPhrase("Breast","Eba"));
        category_human_anatomy.add(new EfikPhrase("Ear","Utɔŋ"));
        category_human_anatomy.add(new EfikPhrase("Eyes","Enyin"));
        category_human_anatomy.add(new EfikPhrase("Finger-Nails","Mbara-Ubɔk"));
        category_human_anatomy.add(new EfikPhrase("Flesh","Ikpɔk Idem"));
        category_human_anatomy.add(new EfikPhrase("Foot Or leg","Ukot"));
        category_human_anatomy.add(new EfikPhrase("Hair","Idet"));
        category_human_anatomy.add(new EfikPhrase("Hand Or Arm","Ubɔk"));
        category_human_anatomy.add(new EfikPhrase("Head","Ibuot"));
        category_human_anatomy.add(new EfikPhrase("Heart; Liver; Chest","Esit"));
        category_human_anatomy.add(new EfikPhrase("Intestine","ŋsia"));
        category_human_anatomy.add(new EfikPhrase("Knee","Erɔŋ"));
        category_human_anatomy.add(new EfikPhrase("Mouth","Inua"));
        category_human_anatomy.add(new EfikPhrase("Neck","Itɔŋ"));
        category_human_anatomy.add(new EfikPhrase("Nose","Ibuo"));
        category_human_anatomy.add(new EfikPhrase("Rib","ɔkpɔ-ŋkaŋ"));
        category_human_anatomy.add(new EfikPhrase("Shoulder","Afara"));
        category_human_anatomy.add(new EfikPhrase("Sole Of Feet","ŋditiŋ-Ikpat"));
        category_human_anatomy.add(new EfikPhrase("Stomach","Idib"));
        category_human_anatomy.add(new EfikPhrase("Toenails","Mbara-Ukot"));
        category_human_anatomy.add(new EfikPhrase("Tongue","Edeme"));
        category_human_anatomy.add(new EfikPhrase("Teeth","Edet"));

        EfikeAdapter adapter = new EfikeAdapter(this,category_human_anatomy,R.color.Category_Human_Anatomy);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

}
