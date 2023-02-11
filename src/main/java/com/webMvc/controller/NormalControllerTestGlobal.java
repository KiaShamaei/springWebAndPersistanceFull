package com.webMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/n")
public class NormalControllerTestGlobal {
    @GetMapping("/1")
    public String n1(){
        throw new RuntimeException("this is run time from normal endpoint");
    }
}
