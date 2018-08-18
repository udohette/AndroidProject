package com.example.android.gridlayout;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DENNIS on 11/13/2016.
 */
public class ViewHolder {
    ImageView myPhrase;
    TextView myTextView;
    ViewHolder(View view){
        myPhrase = (ImageView)view.findViewById(R.id.imageView);
        myTextView = (TextView)view.findViewById(R.id.textView2);

    }
}
