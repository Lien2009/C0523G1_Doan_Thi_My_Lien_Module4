package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("")
    public String showCondiments() {
        return "list";
    }

    @PostMapping("condiment")
    public String getCondiments(Model model,
                                @RequestParam("condiment") String[] condiment) {
        model.addAttribute("condiment", condiment);
        return "list";
    }
}
