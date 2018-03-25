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
    Context context;
    ArrayList<TodoList> lists;
    int color;


    public ListAdapter(Context context, ArrayList<TodoList> lists, int color) {
        this.context = context;
        this.lists = lists;
        this.color = color;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        TodoList todoList = lists.get(position);

        holder.name.setText(todoList.getName());
        holder.description.setText(todoList.getDescription());
        holder.priority.setText(Integer.toString(todoList.getPriority()));
        holder.cardView.setCardBackgroundColor(color);

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        TextView name, description, priority;
        CardView cardView;

        public ListViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.todo_txt);
            description = itemView.findViewById(R.id.description_txt);
            priority = itemView.findViewById(R.id.priority_txt);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
