package com.example.android.mohakbaranshory_1202150004_studycase5;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abay on 3/25/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{
    // Deklarasi Context
    Context context;
    // Deklarasi ArrayList
    ArrayList<TodoList> lists;
    // Deklarasi variabel
    int color;


    // Konstruktor
    public ListAdapter(Context context, ArrayList<TodoList> lists, int color) {
        this.context = context;
        this.lists = lists;
        this.color = color;
    }

    // Menyatukan layout list_todo.xml dengan recycleview
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_todo, parent, false));
    }

    // Membinding data yang didapat dari recycleview
    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        // Get posisi
        TodoList todoList = lists.get(position);

        // set text pada layout
        holder.name.setText(todoList.getName());
        holder.description.setText(todoList.getDescription());
        holder.priority.setText(Integer.toString(todoList.getPriority()));
        holder.cardView.setCardBackgroundColor(color);

    }

    // Mengembalikan nilai besar pada list
    @Override
    public int getItemCount() {
        return lists.size();
    }

    // Inner Class
    class ListViewHolder extends RecyclerView.ViewHolder{
        // Deklarasi Elemen
        TextView name, description, priority;
        CardView cardView;

        // Konstruktor
        public ListViewHolder(View itemView) {
            super(itemView);
            //Inisiasi pada elemen masing-masing
            name = itemView.findViewById(R.id.todo_txt);
            description = itemView.findViewById(R.id.description_txt);
            priority = itemView.findViewById(R.id.priority_txt);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
