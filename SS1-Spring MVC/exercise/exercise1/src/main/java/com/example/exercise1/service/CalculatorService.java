package com.example.exercise1.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int calculator(int rate, int usd){
        int vnd = rate*usd;
        return vnd;
    }
}
