package com.dmuench.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dmuench.taskmaster.project.Project;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

    }

    public void onClickCreateProject (View v) {
        // add inputs to database
        TextView projectTitleView = findViewById(R.id.project_title_input);
        TextView projectDescriptionView = findViewById(R.id.project_description_input);
        String title = projectTitleView.getText().toString();
        String description = projectDescriptionView.getText().toString();

        // creates new project
        Project newProject = new Project(title, description);

        // add to Firebase cloud Firestore
        // Access a Cloud Firestore instance from your Activity
        FirebaseFirestore fireDb = FirebaseFirestore.getInstance();
        fireDb.collection("projects")
                .add(newProject)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

        // return to MainActivity
        finish();
    }

    public void onClickCreateTask (View v) {
        
    }

}
