package com.example.android.miwok;

import com.example.android.miwok.R;
import com.example.android.miwok.Word;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DENNIS on 10/27/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    //Resource id for the background Color for the list of words
    private int mResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word word = getItem(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        if (word.hasImage()) {
            imageView.setImageResource(word.getmWorkImages());
            //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            //Otherwise hide the Image
            imageView.setVisibility(View.GONE);
        }
        //Set the theme color for the list item
        View textContainer = view.findViewById(R.id.text_container);
        // Find the color that the Resource Id maps to
        int color = ContextCompat.getColor(getContext(), mResourceId);
        // set the background color of the text container view
        textContainer.setBackgroundColor(color);
        TextView mDefault = (TextView) view.findViewById(R.id.default_text_view);
        mDefault.setText(word.getmMiworkTranslation());
        TextView mTranslation = (TextView) view.findViewById(R.id.miwork_text_view);
        mTranslation.setText(word.getmDefaultTranslation());
        // Return the whole list item layout(Containing two text views) so that it can be shown
        return view;
    }
}
