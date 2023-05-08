package com.scaler.springbasics.tasks;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    List<Task> taskList = new ArrayList<>();
    private int nextTaskId = 1;

    @GetMapping("")
    List<Task> getAllTasks(
            @RequestParam(value = "completed", required = false) Boolean completed,
            @RequestParam(value = "sort", required = false) String sort
    ){


        var taskFilter = TaskFilter.fromQueryParams(sort, completed);
        if(taskFilter.sort.equals("dateAsc")){

            Collections.sort(taskList, new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    if(o1.getDueDate().before(o2.getDueDate())){
                        System.out.println("in asc if");
                        System.out.println(o1.getDueDate().before(o2.getDueDate()));
                        return -1;
                    }
                    return 1;
                }
            });
        } else if(taskFilter.sort.equals("dateDesc")){
            Collections.sort(taskList, new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    if(o1.getDueDate().before(o2.getDueDate())){
                        return 1;
                    }
                    return -1;
                }
            });
        }

        return taskList;
    }

    @PostMapping("")
    Task createTask(@RequestBody Task task){
        task.setId(nextTaskId++);
        taskList.add(task);
        return task;
    }

    @GetMapping("/{id}")
    Task getTask(@PathVariable("id") Integer id){
        Task task = getTaskById(id);

        return task;
    }

    @PatchMapping("/{id}")
     Task updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO updateTaskDTO )  {
        Task task = getTaskById(id);
        if (updateTaskDTO.getDueDate() != null) {
            task.setDueDate(updateTaskDTO.getDueDate());
        }
        if (updateTaskDTO.completed != null) {
            task.setCompleted(updateTaskDTO.getCompleted());
        }
        return task;
    }

    @DeleteMapping("/{id}")
    Task deleteTask(@PathVariable("id") Integer id){
        Task task = getTaskById(id);
        if(task != null){
            taskList.remove(task);
        }

        return task;
    }

    @DeleteMapping("")
    String deleteAllCompletedTask(){
        taskList.removeIf(task-> task.completed);

        return "All completed task removed";
    }

    public  Task getTaskById(Integer id) {
        for (Task task : taskList) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        throw new ResponseStatusException(NOT_FOUND, "message");
    }
}
