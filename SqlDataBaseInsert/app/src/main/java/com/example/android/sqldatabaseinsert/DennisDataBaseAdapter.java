package com.example.android.sqldatabaseinsert;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DENNIS on 1/10/2017.
 */
public class DennisDataBaseAdapter {
    DennisHelper dennisHelper;

    DennisDataBaseAdapter(Context context) {
        dennisHelper = new DennisHelper(context);
    }

    public long insertData(String name, String password) {
        SQLiteDatabase sqLiteDatabase = dennisHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DennisHelper.NAME, name);
        contentValues.put(DennisHelper.PASSWORD, password);
        long id = sqLiteDatabase.insert(DennisHelper.TABLE_NAME, null, contentValues);
        return id;

    }

    public String getAllData() {
        SQLiteDatabase db = dennisHelper.getWritableDatabase();
        //select _id,Name,password from DennisTable;
        String[] columns = {DennisHelper.UID, DennisHelper.NAME, DennisHelper.PASSWORD};
        Cursor cursor = db.query(DennisHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int cid = cursor.getInt(0);
            String name = cursor.getString(1);
            String password = cursor.getString(2);
            buffer.append(cid + " " + name + " " + password + "\n");
        }
        return buffer.toString();
    }

    public String getData(String name) {
        //select name from dennisTable where name = 'Dennis';
        SQLiteDatabase db = dennisHelper.getWritableDatabase();
        //select _id,Name,password from DennisTable;
        String[] columns = {DennisHelper.NAME, DennisHelper.PASSWORD};
        Cursor cursor = db.query(DennisHelper.TABLE_NAME, columns, DennisHelper.NAME + "='" + name + "'", null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(DennisHelper.NAME);
            int index2 = cursor.getColumnIndex(DennisHelper.PASSWORD);
            String personName = cursor.getString(index1);
            String password = cursor.getString(index2);
            buffer.append(personName + " " + password + "\n");
        }
        return buffer.toString();
    }

    static class DennisHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "dennisdatabase";
        private static final String TABLE_NAME = "DENNISTABLE";
        private static final int DATABASE_VERSION = 2;
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final String PASSWORD = "password";
        private static final String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " VARCHAR(255), " + PASSWORD + "VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME;
        private Context context;

        public DennisHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Message.message(context, "Constructor was Called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //CREATE TABLE DENNISTABLE(_id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(255));";
            try {
                db.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                Message.message(context, "" + e);
                Message.message(context, "onCreate was Called");
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                Message.message(context, "" + e);
                Message.message(context, "onUpgrade was Called");
            }
        }

    }

}

