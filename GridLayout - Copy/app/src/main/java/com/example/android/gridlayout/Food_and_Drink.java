package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Food_and_Drink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings__etiquette);
        ArrayList<EfikPhrase> category_food_drink = new ArrayList<>();
        category_food_drink.add(new EfikPhrase("Avocado","Eben"));
        category_food_drink.add(new EfikPhrase("Bacon","Ekpuba"));
        category_food_drink.add(new EfikPhrase("Banana","Mboro"));
        category_food_drink.add(new EfikPhrase("Cassava","Iwa"));
        category_food_drink.add(new EfikPhrase("Chew Something","Ta ŋkpɔ"));
        category_food_drink.add(new EfikPhrase("Coconut","Isip"));
        category_food_drink.add(new EfikPhrase("Crayfish; Prawns","Obu"));
        category_food_drink.add(new EfikPhrase("Dried(Smoked)Meat","Nsat Unam"));
        category_food_drink.add(new EfikPhrase("Drink","Mmin"));
        category_food_drink.add(new EfikPhrase("Drink Something","ŋwɔŋ ŋkpɔ"));
        category_food_drink.add(new EfikPhrase("Eat Something","Dia ŋkpɔ"));
        category_food_drink.add(new EfikPhrase("Egg","Nsen Unen"));
        category_food_drink.add(new EfikPhrase("Fish","Iyak"));
        category_food_drink.add(new EfikPhrase("Food","Udia"));
        category_food_drink.add(new EfikPhrase("Chicken","Unen"));
        category_food_drink.add(new EfikPhrase("Fresh Fish","Ndek Iyak"));
        category_food_drink.add(new EfikPhrase("Groundnuts; Peanuts","Mmansaŋn"));
        category_food_drink.add(new EfikPhrase("Leaf; Vegetable","Ikɔŋ"));
        category_food_drink.add(new EfikPhrase("Maize; Corn","Ibokpot"));
        category_food_drink.add(new EfikPhrase("Meat","Unam"));
        category_food_drink.add(new EfikPhrase("Oil; Balm; Lotion; Cream","Adan"));
        category_food_drink.add(new EfikPhrase("Orange","Sokoro"));
        category_food_drink.add(new EfikPhrase("Palm Wine","Mmin Efik"));
        category_food_drink.add(new EfikPhrase("Pepper","Ntokon"));
        category_food_drink.add(new EfikPhrase("Plantain","Ukɔm"));
        category_food_drink.add(new EfikPhrase("Plate","Usan"));
        category_food_drink.add(new EfikPhrase("Pot","Esio"));
        category_food_drink.add(new EfikPhrase("Rice","Edesi"));
        category_food_drink.add(new EfikPhrase("Salt","Inuŋ"));
        category_food_drink.add(new EfikPhrase("Soup","Efere"));
        category_food_drink.add(new EfikPhrase("Water","UMmɔŋ"));
        EfikeAdapter efikeAdapter = new EfikeAdapter(this,category_food_drink,R.color.Category_Food_and_Drink);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(efikeAdapter);

    }
}
