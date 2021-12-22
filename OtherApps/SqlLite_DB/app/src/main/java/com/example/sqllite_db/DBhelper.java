package com.example.sqllite_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBhelper extends SQLiteOpenHelper {

    public final static String DBNAME = "users_db";
    public final static int VERSION = 1;
    public DBhelper(Context context)
    {
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE LOGIN (Name TEXT, Username TEXT, Password TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertLogin(String name,String username,String pass)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Name",name);
        cv.put("Username",username);
        cv.put("Password",pass);

        db.insert("LOGIN",null,cv);

    }
    public Boolean LoginUser(String username, String password)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * from LOGIN WHERE Username = '"+username+"' AND Password='"+password+"'";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
            return true;
        return false;
    }
}
