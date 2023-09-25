package com.example.ex1.controller;

import com.example.ex1.dto.UserDto;
import com.example.ex1.model.User;
import com.example.ex1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public ModelAndView showAll(){
        List<User> userList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("list","userList",userList);
        return modelAndView;
    }
    @GetMapping("create")
    public String showFormCreate(Model model){
        model.addAttribute("userDto", new UserDto());
        return "index";
    }
    @PostMapping("create")
    public String save(@Valid @ModelAttribute UserDto userDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.add(user);
        redirectAttributes.addFlashAttribute("message","Created success!");
        return "redirect:/users/create";
    }
}
