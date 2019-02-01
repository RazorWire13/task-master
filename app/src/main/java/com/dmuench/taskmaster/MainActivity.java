package com.dmuench.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dmuench.taskmaster.project.Project;
import com.dmuench.taskmaster.project.ProjectAdapter;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class  MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1977;

    // Resourced code: Code review / Dan Logerstedt
    private RecyclerView projectList;
    private ProjectAdapter projectAdapter;
    private RecyclerView.LayoutManager projectLayoutManager;
    private List<Project> projects;
    private static String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projectList = findViewById(R.id.project_recycler_view);

        projectList.setHasFixedSize(true);

        projectLayoutManager = new LinearLayoutManager(this);
        projectList.setLayoutManager(projectLayoutManager);

        projectAdapter = new ProjectAdapter(projects);
        projectList.setAdapter(projectAdapter);
    }

    public void onClickAddProject (View v) {
        Intent addProject = new Intent(this, CreateProjectActivity.class);
        startActivityForResult(addProject, 1313);
    }

    public void onLoginButtonPress (View v) {
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build());


        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == RC_SIGN_IN) {
                IdpResponse response = IdpResponse.fromResultIntent(data);

                if (resultCode == RESULT_OK) {
                    // Successfully signed in
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    TextView viewProjectList = findViewById(R.id.viewProjectList);
                    viewProjectList.setText(user.getDisplayName() + " Project List");
                    // ...
                } else {
                    // Sign in failed. If response is null the user canceled the
                    // sign-in flow using the back button. Otherwise check
                    // response.getError().getErrorCode() and handle the error.
                    // ...
                }
            }
        }


}
