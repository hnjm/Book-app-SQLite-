package com.example.bookmanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Book.db", null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(title TEXT PRIMARY KEY, author TEXT, pages TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users"); //deletes the table and the specified data

    }

    public boolean addData(String title, String author, String pages){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("author", author);
        contentValues.put("pages", pages);

        long result = myDB.insert("users",null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }

    }

    public boolean checkBookName(String title){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where title = ?", new String[]{title});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    Cursor readAllData(){
        String query = "Select * from users";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
