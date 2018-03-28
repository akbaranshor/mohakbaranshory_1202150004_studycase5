package com.example.android.mohakbaranshory_1202150004_studycase5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    // Instansiasi databasehelper
    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    // Deklarasi elemen EditText
    EditText name, description, priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        // Inisiasi elemen EditText
        name = findViewById(R.id.todo_edit);
        description = findViewById(R.id.desc_edit);
        priority = findViewById(R.id.prio_edit);
    }

    public void tambahTodo(View view) {
        // Buat objek TodoList
        TodoList todoList = new TodoList(name.getText().toString(), description.getText().toString(), Integer.parseInt(priority.getText().toString()));
        // Menambahkan data pada Todolist
        databaseHelper.addList(todoList);
        // Membuat dan menampilkan pesan Toast
        Toast.makeText(this, "Data ditambahkan", Toast.LENGTH_SHORT).show();
        // Pindah ke MainActivity
        startActivity(new Intent(this, MainActivity.class));
    }
}
