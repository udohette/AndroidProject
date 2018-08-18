package com.example.android.searchbar;

/**
 * Created by DENNIS on 1/7/2017.
 */
public class Child_Row {
    private int icon;
    private String text;

    public Child_Row(int icon, String text) {
        this.icon = icon;
        this.text = text;

    }

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
}

