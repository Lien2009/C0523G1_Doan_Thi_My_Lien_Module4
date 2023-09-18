package com.example.controller;

import com.example.model.Email;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("email")
public class EmailController {
    @Autowired
    private IEmailService emailService;
    @ModelAttribute("languages")
    public String[] getLanguage(){
        return emailService.showLanguage();
    }
    @ModelAttribute("sizes")
    public int[] getSize(){
        return emailService.showSize();
    }
    @GetMapping("")
    public ModelAndView display(){
        Email email = emailService.display();
        ModelAndView modelAndView = new ModelAndView("list","email",email);
        return modelAndView;
    }
    @PostMapping("update")
    public String update(@ModelAttribute Email email, RedirectAttributes redirectAttributes){
        emailService.update(email);
        redirectAttributes.addFlashAttribute("mess","Sửa thành công!");
        return "redirect:/email";
    }
}
