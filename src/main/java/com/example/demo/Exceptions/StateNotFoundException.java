package com.example.demo.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StateNotFoundException extends RuntimeException{

    public StateNotFoundException(String message) {
        super(message);
    }
}
