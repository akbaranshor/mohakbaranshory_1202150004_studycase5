package com.example.android.mohakbaranshory_1202150004_studycase5;

/**
 * Created by Abay on 3/25/2018.
 */

public class TodoList {
    // Deklarasi variabel
    String name, description;
    int priority;
    int color = 0;
    // Konstruktor
    public TodoList(int color){
        this.color = color;
    }

    public TodoList(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }
    // Method getter
    public int getColor() {
        return color;
    }
    // Method getter
    public String getName() {
        return name;
    }
    // Method getter
    public String getDescription() {
        return description;
    }
    // Method getter
    public int getPriority() {
        return priority;
    }
}
