package com.example.exercise2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.exercise2.service.TranlatorService;

@Controller
public class TranslatorController {
    @Autowired
    private TranlatorService tranlatorService;
    @GetMapping("")
    public String showTrans(){
        return "translator";
    }
    @PostMapping("translator")
    public String find(@RequestParam String english, Model model){
        String vietnamese = tranlatorService.find(english);
        model.addAttribute("vietnamese",vietnamese);
        return "translator";
    }

}
