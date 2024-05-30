package com.kodilla.good.patterns.factory.tasks;

public interface Task {
    void executeTask();
    String getTaskName();
    boolean isTaskExecuted();
}
