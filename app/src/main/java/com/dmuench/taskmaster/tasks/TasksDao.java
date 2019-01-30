package com.dmuench.taskmaster.tasks;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TasksDao {

    @Query("SELECT * FROM Tasks WHERE taskId = :taskId")
    Tasks getTask (long taskId);

    @Query("SELECT * FROM Tasks WHERE projectId = :projectId")
    List<Tasks> getTasksByProject (long projectId);

    @Query("SELECT * FROM Tasks")
    List<Tasks> getAll();

    @Insert
    void addTask (Tasks task);

    @Update
    void updateTask (Tasks task);

    @Delete
    void deleteTask (Tasks task);
}


