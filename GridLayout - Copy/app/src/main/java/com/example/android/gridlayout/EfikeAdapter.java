package com.example.android.gridlayout;

/**
 * Created by DENNIS on 11/12/2016.
 */

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EfikeAdapter extends ArrayAdapter<EfikPhrase> {
    //Resource id for the background Color for the list of words
    private int mResourceId;

    public EfikeAdapter(Activity context, ArrayList<EfikPhrase> greeting_Eti, int colorResourceId) {
        super(context, 0, greeting_Eti);
        mResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.single_row_2, parent, false);
        }
        EfikPhrase greetings = getItem(position);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        if (greetings.hasImage()) {
            imageView.setImageResource(greetings.getEfikImages());
            //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            //Otherwise hide the Image
            imageView.setVisibility(View.GONE);
            //Set the theme color for the list item
            View textContainer = view.findViewById(R.id.text_container);
            // Find the color that the Resource Id maps to
            int color = ContextCompat.getColor(getContext(), mResourceId);
            // set the background color of the text container view
            textContainer.setBackgroundColor(color);
            TextView eDefault = (TextView) view.findViewById(R.id.text);
            eDefault.setText(greetings.getDefaultTranslation());
            TextView eEfik = (TextView) view.findViewById(R.id.text2);
            eEfik.setText(greetings.getEfikTranslation());
        }
        // Return the whole list item layout(Containing two text views) so that it can be shown
        return view;
    }
}