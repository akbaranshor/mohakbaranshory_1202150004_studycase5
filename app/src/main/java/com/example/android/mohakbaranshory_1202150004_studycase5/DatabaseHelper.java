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
    // Inisiasi secara dinamis, dengan modifier final
    final String TABLE_LIST = "list";

    // Deklarasi SQLiteDatabase, yang digunakan untuk modif data
    SQLiteDatabase db;

    // Konstruktor
    public DatabaseHelper(Context context) {
        // Membuat database
        super(context, "studycase5.db", null, 1);
    }

    /**
     * Membuat tabel pertama kali
     *
     * @param sqLiteDatabase variable
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //SQL Query
        String TABLE_CREATE = "create table "+TABLE_LIST+" (id integer primary key autoincrement," +
        "name varchar(255) not null, description varchar(255) not null, priority integer);";
        // Eksekusi SQL DDL
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Melakukan perubahan tiap jika perubahan versi
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_LIST);
        this.onCreate(sqLiteDatabase);
    }

    /**
     * Menambah item pada TodoList
     *
     * @param todoList merupakan object
     * @return
     */
    public int addList(TodoList todoList) {
        // Membuka database
        db = this.getWritableDatabase();
        // Instansiasi ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", todoList.getName());
        contentValues.put("description", todoList.getDescription());
        contentValues.put("priority", todoList.getPriority());

        if (db.insert(TABLE_LIST, null, contentValues) == -1) return -1;
        else return 1;
    }

    /**
     * Menghapus item pada list
     *
     * @param name nama item yang ingin dihapus
     */
    public void deleteList(String name) {
        //membuka database
        SQLiteDatabase db = this.getWritableDatabase();
        // mengeksekusi query
        db.execSQL("DELETE FROM " + TABLE_LIST+ " WHERE "+"name"+"='"+name+"'");
    }

}
