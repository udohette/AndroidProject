package com.example.android.gridlayout;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DENNIS on 11/13/2016.
 */
public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView myPhrase;
    TextView myTextView;
    ViewHolder(View view){
        super(view);
        myPhrase = (ImageView)view.findViewById(R.id.imageView);
        myTextView = (TextView)view.findViewById(R.id.textView2);

    }
}
