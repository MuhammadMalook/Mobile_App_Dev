package com.example.mad_libs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBhelper extends SQLiteOpenHelper {
    public final static String DBNAME = "studentsDB";
    public final static int VERSION = 1;

    public DBhelper(Context context)
    {
        super(context,DBNAME,null,VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE stories (story_name TEXT, description TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean checkAvailable(String name)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * from stories WHERE story_name='"+name+"'";
        Cursor c = db.rawQuery(query,null);
        System.out.println(c+" inside checkavailable");
        if(c.moveToFirst())
        {
            System.out.println(c+" inside move to firsrt");
            return true;
        }
        else
            return false;
    }
    public void insertStory(String name,String description)
    {
        System.out.println(" inside insertStory");
        if(!checkAvailable(name)) {
            System.out.println(" inside if of  insert");
            SQLiteDatabase db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("story_name", name);
            cv.put("description",description);
            db.insert("stories", null, cv);
        }
    }
    public Cursor getAll()
    {
        System.out.println(" inside getAll");
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * from stories";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor getByname(String name)
    {
        SQLiteDatabase db = getReadableDatabase();
       Cursor cursor = db.rawQuery("SELECT * from stories WHERE story_name='"+name+"'",null);
       return cursor;

    }
}
