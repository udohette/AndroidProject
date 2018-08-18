package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Health extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> health_category = new ArrayList<>();
        health_category.add(new EfikPhrase("Ailment; Sickness; Disease; Illness","Udɔŋɔ"));
        health_category.add(new EfikPhrase("Chill","Tuep"));
        health_category.add(new EfikPhrase("Cough","Ikɔŋ"));
        health_category.add(new EfikPhrase("Fever","Ufiop Idem"));
        health_category.add(new EfikPhrase("Headache","ŋkɔŋibuot"));
        health_category.add(new EfikPhrase("Hospital; Any Medical Establishment","Ufɔk Ibɔk"));
        health_category.add(new EfikPhrase("In Bad Health","Idiɔk Idem"));
        health_category.add(new EfikPhrase("In Good Health","ɔsɔŋ Idem; ɔyɔhɔ Idem"));
        health_category.add(new EfikPhrase("Is Sick; Unwell","ɔdɔŋɔ"));
        health_category.add(new EfikPhrase("Medicine","Ibɔk"));
        health_category.add(new EfikPhrase("Take Medicine","Da Ibɔk"));

        EfikeAdapter efikeAdapter = new EfikeAdapter(this,health_category,R.color.Category_Health);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(efikeAdapter);
    }
}
