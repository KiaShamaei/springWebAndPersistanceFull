package com.webMvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ControllerWithError {
    @GetMapping ("/e1")
    public void testErrorNullPointer(){

        throw  new NullPointerException("this is a null");
    }

}
