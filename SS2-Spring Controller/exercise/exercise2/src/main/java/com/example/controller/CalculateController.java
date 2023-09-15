package com.example.controller;

import com.example.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @Autowired
    private CalculateService service;
    @GetMapping("")
    public String showCalculate(){
        return "list";
    }
    @PostMapping("/calculate")
    public String caculate(@RequestParam double x, @RequestParam double y, @RequestParam Character calculate, Model model){
        if(calculate == '/' & y == 0){
            model.addAttribute("message","Don't divide by 0!");
        } else {
            double result = service.calculate(x,y,calculate);
            model.addAttribute("result",result);
        }
        return "list";
    }
}
