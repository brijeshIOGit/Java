package com.example.taskmanager.tasks;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({
            RuntimeException.class,
            IllegalStateException.class
    })
    String multiExceptionHandler(Exception e){
        if(e instanceof RuntimeException){
            return "Something went wrong";
        }else if(e instanceof IllegalStateException){
            return "Illegal Argument";
        }else{
            return "Idk: Something went wrong";
        }
    }
}
