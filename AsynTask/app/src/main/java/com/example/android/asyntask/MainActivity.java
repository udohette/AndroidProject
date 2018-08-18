package com.example.android.asyntask;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    ListView mainList;
    private String[] texts = {"lorem","ipsum","dolor","sit","amet","consectetur","adipisicing","elit","sed","do","eiusmod","tempor"
    ,"incididunt","ut","labore","et","dolore","magna","aliqua","ut","enim","ad","minim","venian","quis","nostrud","exercitation"
    ,"ullamco","laboris","nisi","ut","aliqui","ex","ex","commodo","consequat","Duis","aute","irure","dolor","in","reprehenderit","in"
    ,"volutate","velit","esse","cillum","dolore","eu","fugiat","nulla","paratur","excepteur","sint","occeacat","cupidatat","non",
    "priodent","sunt","in","culpa","qui","officia","deserunt","mollit","anim","id","est","laborum"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);
        mainList  = (ListView)findViewById(R.id.listView1);
        mainList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));
        new myTask().execute();
    }
    class myTask extends AsyncTask<Void,String,Void>{
        private ArrayAdapter<String> adapter;
        private int count = 0;
        @Override
        protected void onPreExecute() {

            adapter = (ArrayAdapter<String>) mainList.getAdapter();
            setProgressBarIndeterminate(false);
            setProgressBarVisibility(true);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(String item: texts ){
                publishProgress(item);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                        return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            setProgress((int)(((double)count/texts.length)*10000));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            setProgressBarVisibility(false);
            L.s(MainActivity.this,"All item was added successfully");
        }
    }
}
