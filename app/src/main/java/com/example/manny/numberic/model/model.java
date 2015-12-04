package com.example.manny.numberic.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manny on 11/22/2015 AD.
 */
public class model extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "numeric.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "users";
    public static final String COL_ID = "_id";
    public static final String COL_TIME =  "useTime";
    public static final String COL_SCORE = "score";
    public static final String COL_LEVELS = "levels";

    public model(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreateTable = String.format("CREATE TABLE %s ("+
                "%s INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "%s INTEGER, " +
                "%s INTEGER, " +
                "%s STRING);"
                ,TABLE_NAME, COL_ID,COL_LEVELS,COL_SCORE,COL_TIME);
        db.execSQL(sqlCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
