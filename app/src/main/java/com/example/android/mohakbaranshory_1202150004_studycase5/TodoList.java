package com.example.android.mohakbaranshory_1202150004_studycase5;

/**
 * Created by Abay on 3/25/2018.
 */

public class TodoList {
    String name, description;
    int priority;
    int color = 0;

    public TodoList(int color){
        this.color = color;
    }

    public TodoList(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }
    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
