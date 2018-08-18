package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Education extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> education_category = new ArrayList<>();
        education_category.add(new EfikPhrase("Book; Letter; Writing; Certificate; Official Document","ŋwed"));
        education_category.add(new EfikPhrase("Calculation","Ibat"));
        education_category.add(new EfikPhrase("Efik Language","Ikɔ Efik"));
        education_category.add(new EfikPhrase("English Language","Ikɔ Mbakara"));
        education_category.add(new EfikPhrase("Examination","Udomo"));
        education_category.add(new EfikPhrase("Knowledge","Ifiɔk"));
        education_category.add(new EfikPhrase("Place Of Learning; School; College; University","Ufɔk ŋwed"));
        education_category.add(new EfikPhrase("Read; Study","Kot"));
        education_category.add(new EfikPhrase("Scholar","Owo ŋwed"));
        education_category.add(new EfikPhrase("Student; Pupil","Eyen Ufɔk ŋwed"));
        education_category.add(new EfikPhrase("Teacher","Akpep ŋwed"));
        education_category.add(new EfikPhrase("Word","Ikɔ"));
        education_category.add(new EfikPhrase("Write","Wet"));
        education_category.add(new EfikPhrase("Writer","Andiwet"));
        EfikeAdapter efikeAdapter = new EfikeAdapter(this,education_category,R.color.Category_Education);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(efikeAdapter);
    }
}
