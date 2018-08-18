package com.example.android.searchbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by DENNIS on 1/7/2017.
 */
public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<Parent_Row> parent_rowList;
    private ArrayList<Parent_Row> originalList;

    public MyExpandableListAdapter(Context context, ArrayList<Parent_Row> originalList) {
        this.context = context;
        this.parent_rowList = new ArrayList<>();
        this.parent_rowList.addAll(originalList);
        this.originalList = new ArrayList<>();
        this.originalList.addAll(originalList);
    }

    @Override
    public int getGroupCount() {
        return parent_rowList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return parent_rowList.get(groupPosition).getChild_list().size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return parent_rowList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return parent_rowList.get(groupPosition).getChild_list().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {

        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Parent_row parent_row = (Parent_row) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_row, null);
        }
        TextView heading = (TextView) convertView.findViewById(R.id.parent_text);
        heading.setText(parent_row.getName().trim());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Child_Row child_row = (Child_Row) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_row, null);
        }
        ImageView childicon = (ImageView) convertView.findViewById(R.id.child_icon);
        childicon.setImageResource(R.mipmap.ic_launcher);
        final TextView childText = (TextView) convertView.findViewById(R.id.child_text);
        childText.setText(child_row.getText().trim());
        final View finalconvertView = convertView;
        childText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(finalconvertView.getContext(), childText.getText(), Toast.LENGTH_SHORT).show();

            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query) {
        query = query.toLowerCase();
        parent_rowList.clear();
        if (query.isEmpty()) {
            parent_rowList.addAll(originalList);
        } else {
            for (Parent_row parent_row : originalList) {
                ArrayList<Child_Row> child_list = parent_row.getChild_list();
                ArrayList<Child_Row> newList = new ArrayList<Child_Row>();
                for (Child_Row child_row : child_list) {
                    if (child_row.getText().toLowerCase().contains(query)) {
                        newList.add(child_row);
                    }

                }
                if (newList.size() > 0) {
                    Parent_row nparentRow = new Parent_row(parent_row.getName(), newList);
                    parent_rowList.add(parent_row);

                }
            }
        }
        notifyDataSetChanged();
    }

}
