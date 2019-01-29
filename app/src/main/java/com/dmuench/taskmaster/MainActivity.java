package com.dmuench.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dmuench.taskmaster.project.Project;
import com.dmuench.taskmaster.project.ProjectAdapter;
import com.dmuench.taskmaster.project.ProjectDatabase;

import java.util.ArrayList;
import java.util.List;

public class  MainActivity extends AppCompatActivity {

    // Resourced code: Code review / Dan Logerstedt
    private RecyclerView projectList;
    private ProjectAdapter projectAdapter;
    private RecyclerView.LayoutManager projectLayoutManager;
    private List<Project> projects;
    private static String TAG ="MainActivity";

    ProjectDatabase projectDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projectDb = Room.databaseBuilder(getApplicationContext(), ProjectDatabase.class, "projects").allowMainThreadQueries().build();

        projects = projectDb.projectDao().getAll();

        projectList = findViewById(R.id.project_recycler_view);

        projectList.setHasFixedSize(true);

        projectLayoutManager = new LinearLayoutManager(this);
        projectList.setLayoutManager(projectLayoutManager);

        projectAdapter = new ProjectAdapter(projects);
        projectList.setAdapter(projectAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult is called");

        // get data from projectDb
        projects = projectDb.projectDao().getAll();
        projectAdapter.setProjectDataset(projects);
    }

    public void onClickAddProject (View v) {
        Intent addProject = new Intent(this, ProjectActivity.class);
        startActivityForResult(addProject, 1313);
    }

}
