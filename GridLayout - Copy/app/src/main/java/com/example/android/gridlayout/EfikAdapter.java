package com.example.android.gridlayout;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by DENNIS on 11/13/2016.
 */
public class EfikAdapter extends BaseAdapter {
    ArrayList<EfikPhrases> list;
    Context context;
    EfikAdapter(Context context){
        this.context = context;
        list = new ArrayList<>();
        Resources resources = context.getResources();
        String[] tempEfikPhrases = resources.getStringArray(R.array.EfikPhrases);
        int[] EfikPic = {R.drawable.color_black,R.drawable.family_father,R.drawable.color_green,R.drawable.number_three,
        R.drawable.family_grandfather,R.drawable.family_son,R.drawable.number_six,R.drawable.color_red,R.drawable.family_younger_sister,
        R.drawable.color_gray,R.drawable.family_older_brother,R.drawable.family_older_sister,R.drawable.color_dusty_yellow,R.drawable.family_mother,
        R.drawable.color_white,R.drawable.number_seven,R.drawable.number_one,R.drawable.number_ten,R.drawable.number_five,R.drawable.number_two};
        for (int i = 0;i<20;i++){
            EfikPhrases tempPhrases = new EfikPhrases(EfikPic[i],tempEfikPhrases[i]);
            list.add(tempPhrases);
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = null;
        if (row==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row,viewGroup,false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        }else {
            holder = (ViewHolder)row.getTag();
        }
        EfikPhrases temp = list.get(i);
        holder.myPhrase.setImageResource(temp.Images);
        holder.myTextView.setText(temp.EfikeWords);
        return row;
    }
}
