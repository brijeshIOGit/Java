package com.scaler.springbasics.tasks;

public class TaskFilter {
   String sort;
    Boolean completed;

    static TaskFilter fromQueryParams(String sort, Boolean completed) {
        if (sort == null && completed == null) {
            return null;
        }
        TaskFilter taskFilter = new TaskFilter();
        taskFilter.sort = sort;
        taskFilter.completed = completed;
        return taskFilter;
    }
}
