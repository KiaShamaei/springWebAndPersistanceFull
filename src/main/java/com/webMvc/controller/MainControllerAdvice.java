package com.webMvc.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;

@ControllerAdvice
public class MainControllerAdvice {
    Map<String , LongAdder> mapCounter = new ConcurrentHashMap<String, LongAdder>();
    @ModelAttribute
    public void handlerChecker(HttpServletRequest request , Model model){
        String url = request.getRequestURI();
        mapCounter.computeIfAbsent(url,s-> new LongAdder()).increment();
        model.addAttribute("url" , url);
        model.addAttribute("counter" , mapCounter.get(url).sum());
        model.addAttribute("test" , "this from server ...");
    }
}
