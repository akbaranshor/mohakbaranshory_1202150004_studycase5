package com.example.android.mohakbaranshory_1202150004_studycase5;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Abay on 3/25/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    final String TABLE_LIST = "list";
    SQLiteDatabase db;
    public DatabaseHelper(Context context) {
        super(context, "studycase5.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_CREATE = "create table "+TABLE_LIST+" (id integer primary key autoincrement," +
        "name varchar(255) not null, description varchar(255) not null, priority integer);";
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_LIST);
        this.onCreate(sqLiteDatabase);
    }

    public int addList(TodoList todoList) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", todoList.getName());
        contentValues.put("description", todoList.getDescription());
        contentValues.put("priority", todoList.getPriority());

        if (db.insert(TABLE_LIST, null, contentValues) == -1) return -1;
        else return 1;
    }

    public void deleteList(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_LIST+ " WHERE "+"name"+"='"+name+"'");
    }

}
