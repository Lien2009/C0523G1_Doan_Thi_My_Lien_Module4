package com.example.exercise1.controller;

import com.example.exercise1.service.CalculatorService;
import com.example.exercise1.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;
    @GetMapping("")
    public String showCalculator(){
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam double rate, @RequestParam double usd, Model model){
        double vnd = calculatorService.calculator(rate,usd);
        model.addAttribute("vnd",vnd);
        return "calculator";
    }
}
