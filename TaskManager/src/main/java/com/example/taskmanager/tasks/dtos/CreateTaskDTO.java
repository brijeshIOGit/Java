package com.example.taskmanager.tasks.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskDTO {
    String name;
    Date dueDate;
}
