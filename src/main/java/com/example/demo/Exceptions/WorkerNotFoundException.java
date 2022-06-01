package com.example.demo.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WorkerNotFoundException extends RuntimeException{

    public WorkerNotFoundException(String message) {
        super(message);
    }
}
