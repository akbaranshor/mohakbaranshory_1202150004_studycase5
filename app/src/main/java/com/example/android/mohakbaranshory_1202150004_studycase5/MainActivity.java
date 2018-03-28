package com.example.android.mohakbaranshory_1202150004_studycase5;

import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {
    // Deklarasi variabel
    RecyclerView recyclerView;
    ArrayList<TodoList> todoLists;
    ListAdapter listAdapter;

    // Instansiasi DatabaseHelper
    DatabaseHelper databaseHelper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TodoList t = new TodoList(1);

        // Inisiasi pada variabel
        recyclerView = findViewById(R.id.recycleView);
        // memetakan recycleview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Mmebuat array list
        todoLists = new ArrayList<>();
        // Get sharedpreferences
        SharedPreferences sharedPreferences = getSharedPreferences("cardcolor", MODE_PRIVATE);

        // Membuatobjeck
        listAdapter = new ListAdapter(this, todoLists, sharedPreferences.getInt("color", 0));
        // Set adapter pada recycleview
        recyclerView.setAdapter(listAdapter);

        // Membuka database
        final SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // Query
        String selectQuery = "SELECT  name, description, priority FROM list";

        // Cursor
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {

                todoLists.add(new TodoList(
                        c.getString(0),
                        c.getString(1),
                        c.getInt(2)
                ));

            } while (c.moveToNext());
        }

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                TodoList todo = todoLists.get(position);
                databaseHelper.deleteList(todo.getName());
                Toast.makeText(MainActivity.this, "Data dihapus", Toast.LENGTH_SHORT).show();
                //Remove swiped item from list and notify the RecyclerView
                todoLists.remove(position);
                listAdapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int resId = item.getItemId();
        if (resId == R.id.setting) {
            startActivity(new Intent(this, SettingActivity.class));
        }
        return true;
    }

    public void addList(View view) {
        startActivity(new Intent(this, AddActivity.class));
    }

}
