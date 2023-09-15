package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    public double calculate(double x, double y, Character caculation){
        double result = 0;
        switch (caculation){
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            default:
                result = x/y;
                break;
        }
        return result;
    }
}
