package com.dmuench.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dmuench.taskmaster.project.Project;
import com.dmuench.taskmaster.project.ProjectDatabase;

public class ProjectActivity extends AppCompatActivity {

    ProjectDatabase projectDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        projectDb = Room.databaseBuilder(getApplicationContext(), ProjectDatabase.class, "projects").allowMainThreadQueries().build();
    }

    public void onClickCreateProject (View v) {
        // add inputs to database
        TextView projectTitleView = findViewById(R.id.project_title_input);
        TextView projectDescriptionView = findViewById(R.id.project_description_input);
        String title = projectTitleView.getText().toString();
        String description = projectDescriptionView.getText().toString();

        // creates new project
        Project newProject = new Project(title, description);

        // add to database
        projectDb.projectDao().addProject(newProject);

        // return to MainActivity
        finish();
    }

}
