package com.example.android.searchbar;

import java.util.ArrayList;

/**
 * Created by DENNIS on 1/7/2017.
 */
public class Parent_Row {
    private String Name;
    private ArrayList<Child_Row> child_list;

    public Parent_Row(String name, ArrayList<Child_Row> child_list) {
        Name = name;
        this.child_list = child_list;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Child_Row> getChild_list() {
        return child_list;
    }

    public void setChild_list(ArrayList<Child_Row> child_list) {
        this.child_list = child_list;
    }
}

