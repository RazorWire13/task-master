package com.dmuench.taskmaster.project;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmuench.taskmaster.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    // Resourced code: Code review / Dan Logerstedt
    private List<Project> projectDataset;

    public static class ProjectViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout projectTextView;

        public ProjectViewHolder(LinearLayout v) {
            super(v);
            projectTextView = v;
        }
    }

    public ProjectAdapter(List<Project> eData) {
        projectDataset = eData;
    }

    public void setProjectDataset(List<Project> dataSet) {
        this.projectDataset = dataSet;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProjectAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout projectTextView = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.project_text_view, viewGroup, false);

        ProjectViewHolder projectViewHolder = new ProjectViewHolder(projectTextView);
        return projectViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder viewHolder, int i) {
        Project currentProject = projectDataset.get(i);
        ((TextView) viewHolder.projectTextView.findViewById(R.id.project_text_view)).setText(currentProject.getProjectTitle());
        ((TextView) viewHolder.projectTextView.findViewById(R.id.project_description_view)).setText(currentProject.getProjectDescription());
    }

    @Override
    public int getItemCount() {
        return projectDataset.size();
    }
}
