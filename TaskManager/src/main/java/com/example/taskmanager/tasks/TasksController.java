package com.example.taskmanager.tasks;

import com.example.taskmanager.tasks.dtos.CreateTaskDTO;
import com.example.taskmanager.tasks.dtos.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
//    https://8080-cs-c469cbe1-76d6-4587-ba83-e082f0443322.ql-asia-southeast1-glxv.cloudshell.dev/api/quizzes/places&redirectedPreviously=true
//    CONFIG_ID: 2023-05-12r0
//    SERVICE_NAME: quiz-api.endpoints.qwiklabs-gcp-02-2ccda844d042.cloud.goog
    private final TasksService taskService;

    public TasksController(TasksService tasksService){
        this.taskService = tasksService;
    }
    @GetMapping("")
    ResponseEntity<List<Task>> getAllTasks(){

        var tasks  = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);

    }

    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id){
        var task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);

    }

    @PostMapping("")
    ResponseEntity<Task> createTask(@RequestBody CreateTaskDTO createTaskDTO){
        var task = taskService.createTask(createTaskDTO.getName(),createTaskDTO.getDueDate());
        return ResponseEntity.ok(task);
    }
//
//    @PatchMapping("/{id}")
//    ResponseEntity<Task> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO updateTaskDTO){
//
//    }
//
//    @DeleteMapping("/{id}")
//    ResponseEntity<Void> deleteTask(@PathVariable("id") Integer id){
//
//    }

    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    ResponseEntity<String> handleTaskNotFoundException(TasksService.TaskNotFoundException e){
        return ResponseEntity.notFound().build();
    }



}
