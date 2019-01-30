package com.dmuench.taskmaster.tasks;


public enum TaskStatus {

    // https://stackoverflow.com/questions/44498616/android-architecture-components-using-enums

    // create enum statuses
    Available("Available"),
    Assigned("Assigned"),
    Accepted("Accepted"),
    Accomplished("Accomplished");

    private final String status;

    TaskStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
