package com.webMvc.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfigController {
    @Before("execution(* com.webMvc.controller.MainController.mainPage(..))")
    public void getJobPointcut(JoinPoint joinPoint) throws Throwable {
        System.out.println("this is from aop start");
    }
}
