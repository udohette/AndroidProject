package com.example.android.gridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.r_imagegallery);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CreateList> createLists = prepareData();
        MyAdapter adapter = new MyAdapter(getApplicationContext(), createLists);
        recyclerView.setAdapter(adapter);
        
    }
    private ArrayList<CreateList> prepareData(){
        ArrayList<CreateList> theImage = new ArrayList<>();
        for (int i = 0; i < image_titles.length; i++){
            CreateList createList = new CreateList();
            createList.setImage_title(image_titles[i]);
            createList.setImage_ID(image_ids[i]);
            theImage.add(createList);
        }
        return theImage;
    }

    private final String image_titles[] = {"Img1", "Img2", "Img3", "Img4", "Img5", "Img6", "Img7", "Img8", "Img9", "Img10", "Img11",
            "Img12",
            "Img13"};
    private final Integer image_ids[] = {R.drawable.family_grandfather,R.drawable.family_father,R.drawable.family_daughter,
    R.drawable.color_black,R.drawable.color_mustard_yellow,R.drawable.color_green,R.drawable.color_brown,R.drawable.color_red,
    R.drawable.family_grandmother,R.drawable.color_white,R.drawable.family_older_brother,R.drawable.family_older_sister,
    R.drawable.number_five,R.drawable.number_two};

    }

