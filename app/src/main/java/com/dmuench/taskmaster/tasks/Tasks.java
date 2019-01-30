package com.dmuench.taskmaster.tasks;

import com.dmuench.taskmaster.project.Project;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity
(foreignKeys = @ForeignKey(entity = Project.class,
        parentColumns = "id",
        childColumns = "projectId",
        onDelete = CASCADE))

public class Tasks {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private long taskId;
    private long projectId;
    public String title;
    public String description;
    public String status;

    public Tasks() {
    }

    public Tasks(long projectId, String title, String description, String status) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getTaskTitle () {
        return this.title;
    }

    public String getTaskDescription () {
        return this.description;
    }

    public String getTaskStatus () { return  this.status; }

    public String toString() {
        return this.title + " | " + this.description + " | " + this.status;
    }
}


