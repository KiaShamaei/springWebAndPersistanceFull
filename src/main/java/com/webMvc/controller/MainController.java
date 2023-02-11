package com.webMvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("/job")
    public String mainPage(Model model){
        return "bb";
    }
    @GetMapping("/counter")
    public String counterPage(Model model){
        return "counter";
    }
}
