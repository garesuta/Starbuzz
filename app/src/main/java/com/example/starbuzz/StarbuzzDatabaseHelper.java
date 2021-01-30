package com.example.starbuzz;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper{
    StarbuzzDatabaseHelper(Context context){

    }
    @Override
    public void onCreate(SQLiteDatabase db){

    }
    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
