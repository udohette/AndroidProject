package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> category_shopping = new ArrayList<EfikPhrase>();
        category_shopping.add(new EfikPhrase("All","Kpukpru"));
        category_shopping.add(new EfikPhrase("Business","Mbubehe"));
        category_shopping.add(new EfikPhrase("Buy Something","Dep ŋkpɔ"));
        category_shopping.add(new EfikPhrase("Cheap; Reasonably Priced","Isɔŋke Okuk"));
        category_shopping.add(new EfikPhrase("Expensive; Dear","ɔsɔŋ Okuk; Akpa Okuk"));
        category_shopping.add(new EfikPhrase("Extra; Surplus","Udori"));
        category_shopping.add(new EfikPhrase("Here Is (The) Money","Se Okuk Mi"));
        category_shopping.add(new EfikPhrase("How Much","Okuk Ifaŋ"));
        category_shopping.add(new EfikPhrase("How Much Does It Cost","Akpa Okuk Ifaŋ"));
        category_shopping.add(new EfikPhrase("I Will pay","Nyekpe"));
        category_shopping.add(new EfikPhrase("I Will Take All","Nyeda Kpupkru"));
        category_shopping.add(new EfikPhrase("I Will Take Some","Nyeda Ubak"));
        category_shopping.add(new EfikPhrase("Increase Price","Sin Urua"));
        category_shopping.add(new EfikPhrase("Let Me Have My Change","Nɔ Mi Udianare Mi"));
        category_shopping.add(new EfikPhrase("Money","Okuk"));
        category_shopping.add(new EfikPhrase("More Expensive Than","ɔsɔŋ Okuk Akan"));
        category_shopping.add(new EfikPhrase("Part; Piece; Some","Ubak"));
        category_shopping.add(new EfikPhrase("Pay","Kpe"));
        category_shopping.add(new EfikPhrase("Reduce Price","Sio Urua"));
        category_shopping.add(new EfikPhrase("Sell Something","Yam ŋkpɔ"));
        category_shopping.add(new EfikPhrase("Shopping; Market; Trade","Urua"));
        category_shopping.add(new EfikPhrase("Take Your Change","Bɔ Udianare Fo"));
        category_shopping.add(new EfikPhrase("That One","Enye Oko"));
        category_shopping.add(new EfikPhrase("This Ones","Enye Mi"));
        category_shopping.add(new EfikPhrase("Those Ones","Mme Enye Oko"));
        category_shopping.add(new EfikPhrase("Trade; Bargain","Nam Urua"));


        EfikeAdapter adapter = new EfikeAdapter(this,category_shopping,R.color.Category_Shopping);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
