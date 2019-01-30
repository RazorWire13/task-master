package com.dmuench.taskmaster.tasks;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Tasks.class}, version = 1, exportSchema = false)
public abstract class TaskDatabase extends RoomDatabase {
    public abstract TasksDao tasksDao() ;
}
