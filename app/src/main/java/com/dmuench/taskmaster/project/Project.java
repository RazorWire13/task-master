package com.dmuench.taskmaster.project;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Project {
    @PrimaryKey(autoGenerate = true)
    public long projectId;
    public String title;
    public String description;

    public Project() {
    }

    public Project(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getProjectTitle () {
        return this.title;
    }

    public String getProjectDescription () {
        return this.description;
    }

    public String toString() {
        return this.title + " | " + this.description;
    }
}

