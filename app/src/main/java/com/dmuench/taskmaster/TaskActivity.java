package com.dmuench.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dmuench.taskmaster.tasks.TaskDatabase;
import com.dmuench.taskmaster.tasks.TaskStatus;
import com.dmuench.taskmaster.tasks.Tasks;

public class TaskActivity extends AppCompatActivity {

    TaskDatabase taskDb;
    long projectId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        taskDb = Room.databaseBuilder(getApplicationContext(), TaskDatabase.class, "tasks").allowMainThreadQueries().build();
    }

    public void onClickCreateTask (View v) {
        // add task inputs to database
        TextView taskTitleView = findViewById(R.id.task_title_input);
        TextView taskDescriptionView = findViewById(R.id.task_description_input);
        String title = taskTitleView.getText().toString();
        String description = taskDescriptionView.getText().toString();


        // creates new project
        Tasks newTask = new Tasks(projectId, title, description, TaskStatus.Available.toString());

        // add to database
        taskDb.tasksDao().addTask(newTask);

        // return to MainActivity
        finish();
    }
}

