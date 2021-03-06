package com.example.listviewlab7_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBhelper extends SQLiteOpenHelper {
    public final static String DBNAME = "usersDB";
    public final static int VERSION = 1;
    public DBhelper(Context context){
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE users (Name TEXT, Email TEXT, Phone Text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertData(String name,String email,String phone)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Name",name);
        cv.put("Email",email);
        cv.put("Phone",phone);
        db.insert("users",null,cv);
    }
    public Cursor getUsers()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM users";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
}
