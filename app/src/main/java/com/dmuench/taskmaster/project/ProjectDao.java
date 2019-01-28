package com.dmuench.taskmaster.project;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProjectDao {

    @Query("SELECT * FROM Project WHERE id = :id")
    Project getProject (long id);

    @Query("SELECT * FROM Project")
    List<Project> getAll();

    //Resourced from: https://stackoverflow.com/questions/5191503/how-to-select-the-last-record-of-a-table-in-sql
    @Query("SELECT * FROM Project ORDER BY id DESC LIMIT 1")
    Project getLast();

    @Insert
    void addProject (Project project);

    @Update
    void updateProject (Project project);

    @Delete
    void deleteProject (Project project);
}

