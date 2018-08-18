package com.example.android.searchbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    ListView listView;
    String[] items;
    ArrayList<String> listitems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text_item);
        editText = (EditText)findViewById(R.id.textEdit);
        listView = (ListView)findViewById(R.id.listView);
        initList();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    // reset listView;
                    initList();
                }else {
                    //perform search;
                    searchItem(s.toString());

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public  void searchItem(String textToSearch){
        for(String item:items){
            if(!item.contains(textToSearch)){
                listitems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();

    }
    public void initList(){
        items = new String[]{"China","Nigeria","Russia","USA"};
        listitems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this,R.layout.list_view,R.id.text_item);
        listView.setAdapter(adapter);
    }
}
