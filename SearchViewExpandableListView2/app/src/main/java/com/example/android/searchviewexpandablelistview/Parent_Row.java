package com.example.android.searchviewexpandablelistview;

import java.util.ArrayList;

/**
 * Created by DENNIS on 1/15/2017.
 */
public class Parent_Row {
    private String name;
    private ArrayList<Child_Row> childList;

    public Parent_Row(String name, ArrayList<Child_Row> childList) {
        this.childList = childList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Child_Row> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<Child_Row> childList) {
        this.childList = childList;
    }

    public Parent_Row(String name) {
        this.name = name;


    }
}
