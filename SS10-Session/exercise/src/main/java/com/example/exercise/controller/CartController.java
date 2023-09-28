package com.example.exercise.controller;

import com.example.exercise.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("cart")
public class CartController {
    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute(value = "cart",required = false)CartDto cartDto){
        return new ModelAndView("cart-list","cart",cartDto);
    }
}
