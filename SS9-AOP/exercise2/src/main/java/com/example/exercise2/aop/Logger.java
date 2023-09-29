package com.example.exercise2.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private int count = 0;
    @After("execution(* com.example.exercise2.controller.*.*Book(..))")
    public void countChangeQuantityBook(){
        count++;
        System.out.println("The number of times the book status is changed is "+ count);
    }
    @After("execution(* com.example.exercise2.controller.*.*(..))")
    public void countVisit(){
        count++;
        System.out.println("The number of visiting is "+ count);
    }
}
