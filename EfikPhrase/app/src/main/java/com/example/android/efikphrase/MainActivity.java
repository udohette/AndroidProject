package com.example.android.efikphrase;

import android.content.Intent;
import android.graphics.Color;
import android.icu.util.ULocale;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Category_Greetings_Etiquette = (TextView) findViewById(R.id.Category_Greetings_Etiquette);
        Category_Greetings_Etiquette.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Greeting_Etiquette = new Intent(MainActivity.this, Greetings_Etiquette.class);
                startActivity(Greeting_Etiquette);
            }
        });
        TextView Category_Color = (TextView) findViewById(R.id.Category_Colors);
        Category_Color.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Colors = new Intent(MainActivity.this, Colors.class);
                startActivity(Colors);
            }
        });
        TextView category_animals = (TextView) findViewById(R.id.category_Animals);
        category_animals.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent animals = new Intent(MainActivity.this, Animals.class);
                startActivity(animals);

            }
        });
        TextView category_around_the_house = (TextView) findViewById(R.id.around_the_house);
        category_around_the_house.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent around_the_house = new Intent(MainActivity.this, Around_the_House.class);
                startActivity(around_the_house);
            }
        });
        TextView category_clothing = (TextView) findViewById(R.id.Clothing);
        category_clothing.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category_clothing = new Intent(MainActivity.this, Around_the_House.class);
                startActivity(category_clothing);
            }
        });
        TextView landscape= (TextView) findViewById(R.id.category_landscape);
        landscape.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category_landscape = new Intent(MainActivity.this, Landscape.class);
                startActivity(category_landscape);
            }
        });
        TextView directions= (TextView) findViewById(R.id.category_directions);
        directions.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category_dirctions = new Intent(MainActivity.this, Directions.class);
                startActivity(category_dirctions);
            }
        });
    }
}