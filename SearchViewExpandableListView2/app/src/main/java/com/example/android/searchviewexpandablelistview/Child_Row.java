package com.example.android.searchviewexpandablelistview;

/**
 * Created by DENNIS on 1/15/2017.
 */
public class Child_Row {
    private  int icon;
    private String text;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Child_Row(int icon, String text) {
        this.icon = icon;
        this.text = text;

    }
}
