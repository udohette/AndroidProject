package com.example.android.sqldatabase;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DENNIS on 1/5/2017.
 */
public class DennisHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dennisdatabase";
    private static final String TABLE_NAME = "DENNISTABLE";
    private static final int DATABASE_VERSION = 3;
    private static final String UID = "_id";
    private static final String NAME = "Name";
    private static final String CREATE_TABLE = "CREATE TABLE"+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS"+TABLE_NAME;
    private Context context;
    public DennisHelper(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
        this.context=context;
        Message.message(context,"Constructor was Called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE DENNISTABLE(_id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(255));";
        try {
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            Message.message(context,""+e);
            Message.message(context,"onCreate was Called");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
            Message.message(context,""+e);
            Message.message(context,"onUpgrade was Called");
        }

    }
}
