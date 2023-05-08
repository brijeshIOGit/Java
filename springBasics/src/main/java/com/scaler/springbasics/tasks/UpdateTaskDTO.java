package com.scaler.springbasics.tasks;

import java.util.Date;


public class UpdateTaskDTO {
    Date dueDate;
    Boolean completed;
    public Date getDueDate() {
        return dueDate;
    }

    public UpdateTaskDTO setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public UpdateTaskDTO setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }


}
