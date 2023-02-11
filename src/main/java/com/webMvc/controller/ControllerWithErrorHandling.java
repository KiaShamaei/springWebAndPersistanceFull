package com.webMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error2")
public class ControllerWithErrorHandling {
    @ExceptionHandler(NullPointerException.class)
    public String nullHandler(NullPointerException e, Model m) {
        m.addAttribute("error", e);
        return "error";
    }

    @GetMapping("/handler1")
    public void createError() {
        throw new NullPointerException("test");
    }
}
