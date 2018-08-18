package com.example.android.searchwidget;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ListView2 extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] titlrArray;
    String[] descriptionArry;
    ListView2(Context context, String[] titles, int Imgs[], String[] desc){
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
