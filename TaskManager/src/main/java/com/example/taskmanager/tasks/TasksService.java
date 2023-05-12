package com.example.taskmanager.tasks;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TasksService {

    private List<Task> tasks = new ArrayList<>();
    private Integer id = 0;
    public List<Task> getAllTasks(){
        return tasks;
    }

    public Task getTaskById(Integer id){
        for(Task task: tasks){
            if(task.getId().equals(id)){
                return task;
            }
        }
        throw new TaskNotFoundException(id);
    }

    public Task createTask(String name, Date dueDate){
        Task task = new Task(id++,name,dueDate,false);
        tasks.add(task);
        return task;
    }

    public Task updateTask(Integer id, Date dueDate, Boolean completed){
        Task task = getTaskById(id);
        if(dueDate != null){
            task.setDueDate(dueDate);
        }
        if(completed != null){
            task.setCompleted(completed);
        }

        return task;
    }

    public void deleteTask(Integer id){
        Task task = getTaskById(id);
        tasks.remove(task);


    }

    public static class TaskNotFoundException extends IllegalStateException{
        public TaskNotFoundException(Integer id) {
            super("Task with id "+id+" not found");

        }
    }



}
