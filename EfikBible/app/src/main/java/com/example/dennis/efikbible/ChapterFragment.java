package com.example.dennis.efikbible;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import static android.widget.ArrayAdapter.createFromResource;

/**
 * Created by DENNIS on 7/18/2018.
 */

public class ChapterFragment extends Fragment implements AdapterView.OnItemClickListener{
    GridView gridView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.chapter_fragment,container,false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView = (GridView) getActivity().findViewById(R.id.grid);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.Chapters,android.R.layout.simple_gallery_item);
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(this);

    }
    public void changeData(int position){
        Resources resources = getResources();
        int[] dscription = resources.getIntArray(R.array.Chapters);
        gridView.setSelection(dscription[position]);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        changeData(position);
    }
}
