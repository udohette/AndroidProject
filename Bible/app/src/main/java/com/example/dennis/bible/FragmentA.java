package com.example.dennis.bible;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by DENNIS on 7/19/2018.
 */

public class FragmentA extends Fragment implements AdapterView.OnItemClickListener{
    Communication communication;
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_a,container,false);
        listView = (ListView)view.findViewById(R.id.list);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.Books,android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);


        return view;
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        communication.respond(position);

    }
    public interface Communication{
        public void respond(int index);
    }
}
