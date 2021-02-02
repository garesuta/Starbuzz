package com.example.starbuzz;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "starbuzz";
    private static final int DB_VERSION = 1;
    StarbuzzDatabaseHelper(Context context){
        super(context, DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"NAME TEXT,"
                +"DESCRIPTION TEXT,"
                + "IMAGE_RESOURCE_ID INTEGER);");
        insertDrink(db,"Latte","Espresso and Steamed milk", R.drawable.latte);
        insertDrink(db,"Cappuccino","Espresso, hot milk and steamed milk foam",R.drawable.cappuccino);
        insertDrink(db, "Filter", "Our vest drip coffee",R.drawable.filter);
    }
    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
    private static void insertDrink(SQLiteDatabase db, String name,
                                    String description, int resourceId){
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME",name);
        drinkValues.put("DESCRIPTION",description);
        drinkValues.put("IMAGE_RESOURCE_ID",resourceId);
        db.insert("DRINK",null,drinkValues);
    }
}
