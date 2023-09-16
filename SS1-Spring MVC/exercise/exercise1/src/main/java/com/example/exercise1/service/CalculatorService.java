package com.example.exercise1.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{

    @Override
    public double calculator(double rate, double usd) {
        double vnd = rate * usd;
        return vnd;
    }
}
