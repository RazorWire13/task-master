package com.dmuench.taskmaster.tasks;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TasksDao {

    @Query("SELECT * FROM Project WHERE id = :id")
    Tasks getTasks (long id);

    @Query("SELECT * FROM Project")
    List<Tasks> getAll();

    //Resourced from: https://stackoverflow.com/questions/5191503/how-to-select-the-last-record-of-a-table-in-sql
    @Query("SELECT * FROM Project ORDER BY id DESC LIMIT 1")
    Tasks getLast();

    @Insert
    void addProject (Tasks task);

    @Update
    void updateProject (Tasks task);

    @Delete
    void deleteProject (Tasks task);
}


