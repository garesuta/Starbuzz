package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;
import android.view.View;
import android.widget.CheckBox;
import android.content.ContentValues;


public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        //get the drink from the intent
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);
        //create cursor
        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try {
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME","DESCRIPTION","IMAGE_RESOURCE_ID","FAVORITE"},
                    "_id = ?",
                    new String[] {Integer.toString(drinkId)},
                    null,null,null);
        if(cursor.moveToFirst()){
            String nameText = cursor.getString(0);
            String descriptionText = cursor.getString(1);
            int photoId = cursor.getInt(2);
            boolean isFavorite = (cursor.getInt(3)==1);

            TextView name = (TextView) findViewById(R.id.name);
            name.setText(name);

            TextView description = (TextView)findViewById(R.id.description);
            description.setText(descriptionText);

            ImageView photo = (ImageView)findViewById(R.id.photo);
            photo.setImageResource(photoId);
            photo.setContentDescription(nameText);

            CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
            favorite.setChecked(isFavorite);
        }
            cursor.close();
            db.close();
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"Database is unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void  onFavoriteClicked(View view){
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);

        CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("FAVORITE",favorite.isChecked());

        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try{
            SQLiteDatabase db = starbuzzDatabaseHelper.getWritableDatabase();
            db.update("DRINK",
                    drinkValues,
                    "_id = ?",
                    new String[]{Integer.toString(drinkId)});
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this,"Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
