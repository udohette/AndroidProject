package com.example.android.fragment_class2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by DENNIS on 12/7/2016.
 */
public class FragmentB extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        textView = (TextView)view.findViewById(R.id.textView);

        return view;
    }
    public  void changeData(int index){
        String[] descriptions = getResources().getStringArray(R.array.description);
        textView.setText(descriptions[index]);

    }
}
