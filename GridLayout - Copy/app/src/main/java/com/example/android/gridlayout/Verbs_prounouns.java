package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Verbs_prounouns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> category_verbs_pronouns = new ArrayList<EfikPhrase>();
        category_verbs_pronouns.add(new EfikPhrase("I Am","Ami Ndi"));
        category_verbs_pronouns.add(new EfikPhrase("Hers/His","Eke Esie"));
        category_verbs_pronouns.add(new EfikPhrase("Mine","Ekim"));
        category_verbs_pronouns.add(new EfikPhrase("Ours","AEke Nnyin"));
        category_verbs_pronouns.add(new EfikPhrase("She/He Is","Enye Edi"));
        category_verbs_pronouns.add(new EfikPhrase("That","Enye Oko"));
        category_verbs_pronouns.add(new EfikPhrase("Theirs","Eke Mmɔ"));
        category_verbs_pronouns.add(new EfikPhrase("Them","Mmɔ"));
        category_verbs_pronouns.add(new EfikPhrase("They Are","Mɔ Edi"));
        category_verbs_pronouns.add(new EfikPhrase("This","Enye Mi"));
        category_verbs_pronouns.add(new EfikPhrase("Those","Mme Enye Oko"));
        category_verbs_pronouns.add(new EfikPhrase("We Are","Nnyin Idi"));
        category_verbs_pronouns.add(new EfikPhrase("You Are","Afo Edi"));
        category_verbs_pronouns.add(new EfikPhrase("Yours","Eke Mbufo; Okuo"));


        EfikeAdapter adapter = new EfikeAdapter(this,category_verbs_pronouns,R.color.Category_Verbs_and_Pronouns);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
