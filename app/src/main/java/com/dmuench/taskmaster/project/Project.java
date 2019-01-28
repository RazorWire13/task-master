package com.dmuench.taskmaster.project;

import com.dmuench.taskmaster.tasks.Tasks;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Project {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String title;
    public String description;
    public List<Tasks> tasks;

    public Project() {
    }

    public Project(String title, String description, List<Tasks> tasks) {
        this.title = title;
        this.description = description;
        this.tasks = tasks;
    }
    public String toString() {
        return this.title + " | " + this.description + " | " + this.tasks + ", ";
    }
}

