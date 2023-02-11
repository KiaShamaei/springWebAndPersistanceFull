package com.webMvc.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalErrorHandling {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String globalHandler(Exception e){
        return "this is from global handler -----> "+e.getMessage();
    }
}
