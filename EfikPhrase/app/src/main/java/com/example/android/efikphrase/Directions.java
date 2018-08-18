package com.example.android.efikphrase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Directions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> directions = new ArrayList<>();
        directions.add(new EfikPhrase("Before,","Mbemiso"));
        directions.add(new EfikPhrase("Behind","Ke Edem"));
        directions.add(new EfikPhrase("End (Of The Road)","Akpatre"));
        directions.add(new EfikPhrase("Far; Distant","Oyom Usuŋ"));
        directions.add(new EfikPhrase("Front; Ahead","Iso"));
        directions.add(new EfikPhrase("Go","Ka"));
        directions.add(new EfikPhrase("Go Straight","Ka Nnen-Nnen"));
        directions.add(new EfikPhrase("Here; Over Here","Mi"));
        directions.add(new EfikPhrase("In Front","Ke Iso"));
        directions.add(new EfikPhrase("Left","Ufien"));
        directions.add(new EfikPhrase("Near","Ekpere"));
        directions.add(new EfikPhrase("Near Me,","kpere Mi"));
        directions.add(new EfikPhrase("Not Far,","Ekpere Usuŋ"));
        directions.add(new EfikPhrase("Over There; Yonder","Ko"));
        directions.add(new EfikPhrase("Pass Through; Via,","Saŋa Be"));
        directions.add(new EfikPhrase("Arrive;Reach,","Sim"));
        directions.add(new EfikPhrase("Ride; Drive","Wat"));
        directions.add(new EfikPhrase("Right","Nnasia"));
        directions.add(new EfikPhrase("Side","Mben"));
        directions.add(new EfikPhrase("Side Ways","Mben-Mben"));
        directions.add(new EfikPhrase("Stop; End","Tre"));
        directions.add(new EfikPhrase("Straight","Nnen-Nnen"));
        directions.add(new EfikPhrase("That Place","Itie Odo"));
        directions.add(new EfikPhrase("This Place","Itie Emi"));
        directions.add(new EfikPhrase("There","Do"));
        directions.add(new EfikPhrase("Turn","Wahade"));
        directions.add(new EfikPhrase("Turn","Wahade"));
        directions.add(new EfikPhrase("Turn Left","Wahahe Ke Ufien"));
        directions.add(new EfikPhrase("Turn Right","Wahade Ke Nnasia"));
        directions.add(new EfikPhrase("Turn There","Wahade Do"));
        directions.add(new EfikPhrase("Turn; Turn Back; U-turn","ŋwɔŋɔde"));
        directions.add(new EfikPhrase("Turn","Wahade"));
        EfikeAdapter adapter = new EfikeAdapter(this,directions,R.color.Category_Directions);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
