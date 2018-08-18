package com.example.android.gridlayout;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView myGrid = (GridView) findViewById(R.id.gridView);
        myGrid.setAdapter(new EfikAdapter(this));
        myGrid.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EfikPhrases phrase = (EfikPhrases) parent.getAdapter().getItem(position);
        int imageId = phrase.Images;
        if (imageId == R.drawable.color_black) {
            Intent intent = new Intent(MainActivity.this, Greetings_Etiquette.class);
            startActivity(intent);
        } else if (imageId == R.drawable.family_father) {
            Intent intent = new Intent(MainActivity.this, Animals.class);
            startActivity(intent);
        } else {
            if (imageId == R.drawable.color_green) {
                Intent intent = new Intent(MainActivity.this, Around_the_House.class);
                startActivity(intent);
            } else {
                if (imageId == R.drawable.number_three) {
                    Intent intent = new Intent(MainActivity.this, Clothing.class);
                    startActivity(intent);
                } else {
                    if (imageId == R.drawable.family_grandfather) {
                        Intent intent = new Intent(MainActivity.this, Colors.class);
                        startActivity(intent);
                    } else {
                        if (imageId == R.drawable.family_son) {
                            Intent intent = new Intent(MainActivity.this, Landscape.class);
                            startActivity(intent);
                        } else {
                            if (imageId == R.drawable.number_six) {
                                Intent intent = new Intent(MainActivity.this, Directions.class);
                                startActivity(intent);
                            } else {
                                if (imageId == R.drawable.color_red) {
                                    Intent intent = new Intent(MainActivity.this, Education.class);
                                    startActivity(intent);
                                } else {
                                    if (imageId == R.drawable.family_younger_sister) {
                                        Intent intent = new Intent(MainActivity.this, Food_and_Drink.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.color_gray) {
                                        Intent intent = new Intent(MainActivity.this, Meeting_People.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.family_older_brother) {
                                        Intent intent = new Intent(MainActivity.this, Religion.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.family_older_sister) {
                                        Intent intent = new Intent(MainActivity.this, Sums_Ordinal.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.color_dusty_yellow) {
                                        Intent intent = new Intent(MainActivity.this, Time.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.family_mother) {
                                        Intent intent = new Intent(MainActivity.this, Verbs_prounouns.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.color_white) {
                                        Intent intent = new Intent(MainActivity.this, Weather.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.number_seven) {
                                        Intent intent = new Intent(MainActivity.this, Shopping.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.number_ten) {
                                        Intent intent = new Intent(MainActivity.this, Human_anatomy.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.number_one) {
                                        Intent intent = new Intent(MainActivity.this, Numbers.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.number_five) {
                                        Intent intent = new Intent(MainActivity.this, Health.class);
                                        startActivity(intent);
                                    } else if (imageId == R.drawable.number_two) {
                                        Intent intent = new Intent(MainActivity.this, Names_meaning.class);
                                        startActivity(intent);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}

