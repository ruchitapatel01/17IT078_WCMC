package com.example.a17it078_wcmc.Fragment.p10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.a17it078_wcmc.Core.ConstantString;

public class DatabaseHelper extends SQLiteOpenHelper {

    long result;

    public DatabaseHelper(@Nullable Context context) {
        super(context, ConstantString.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ConstantString.TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, MARKS INTEGER)");
       // db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantString.TABLE_NAME);
        onCreate(db);
      //  db.close();
    }

    public boolean insertData(String name,String surname,String marks){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantString.COL_2,name);
        contentValues.put(ConstantString.COL_3,surname);
        contentValues.put(ConstantString.COL_4,marks);
        result = DB.insert(ConstantString.TABLE_NAME,null,contentValues);
       // DB.close();
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor res = DB.rawQuery("select * from " +ConstantString.TABLE_NAME,null);
    //    DB.close();
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantString.COL_1,id);
        contentValues.put(ConstantString.COL_2,name);
        contentValues.put(ConstantString.COL_3,surname);
        contentValues.put(ConstantString.COL_4,marks);
        DB.update(ConstantString.TABLE_NAME,contentValues,"ID = ?",new String[] { id });
    //    DB.close();
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.delete(ConstantString.TABLE_NAME,"ID = ?",new String[] { id });
    }
}
