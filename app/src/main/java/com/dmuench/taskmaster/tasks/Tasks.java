package com.dmuench.taskmaster.tasks;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tasks {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String title;
    public String description;
    public String status;

    public Tasks() {
    }

    public Tasks(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }
    public String toString() {
        return this.title + " | " + this.description + " | " + this.status;
    }
}


