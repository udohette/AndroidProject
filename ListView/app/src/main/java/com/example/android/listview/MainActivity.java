package com.example.android.listview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
   String[] MemeTiles;
    String[] MemeDescription;
    int[] images ={R.drawable.images_icon,R.drawable.images_icon2,R.drawable.images_icon3,R.drawable.images_icon4,R.drawable.images_icon5,
    R.drawable.images_icon6,R.drawable.images_icon7,R.drawable.images_icon8,R.drawable.images_icon9,R.drawable.images_icon10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        MemeTiles =res.getStringArray(R.array.titles);
        MemeDescription =res.getStringArray(R.array.description);
        listView = (ListView)findViewById(R.id.listView);
       ListView2 adapter = new ListView2(this,MemeTiles,images,MemeDescription);
        listView.setAdapter(adapter);
        //Intent intent = new Intent(this,ScrollingActivity.class);
        //startActivity(intent);

    }
}
class ListView2 extends ArrayAdapter<String>{
    Context context;
    int[] images;
    String[] titlrArray;
    String[] descriptionArry;
    ListView2(Context context,String[] titles,int Imgs[],String[] desc){
        super(context,R.layout.single_row,R.id.textView,titles);
        this.context=context;
        this.images=Imgs;
        this.titlrArray = titles;
        this.descriptionArry=desc;
    }
    class myViewHolder{
        ImageView myImage;
        TextView myTitle;
        TextView myDescription;
        myViewHolder(View v){
            myImage = (ImageView)v.findViewById(R.id.imageView);
            myTitle = (TextView)v.findViewById(R.id.textView);
            myDescription = (TextView)v.findViewById(R.id.textView2);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        myViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder = new myViewHolder(row);
            row.setTag(holder);
            Log.d("Dennis","Creating a new Row");
        }
        else {
            holder = (myViewHolder)row.getTag();
            Log.d("Dennis","Recycling Stuff");
        }



        holder.myImage.setImageResource(images[position]);
        holder.myTitle.setText(titlrArray[position]);
        holder.myDescription.setText(descriptionArry[position]);

        return row;
    }
}
