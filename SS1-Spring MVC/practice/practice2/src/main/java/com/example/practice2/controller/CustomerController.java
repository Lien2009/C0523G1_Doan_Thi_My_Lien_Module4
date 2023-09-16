package com.example.practice2.controller;

import com.example.practice2.model.Customer;
import com.example.practice2.service.CustomerService;
import com.example.practice2.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping()
    public String showList(Model model){
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers",customers);
        return "list";
    }
    @GetMapping("{id}")
    public String showInformation(@PathVariable int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "info";
    }
    @PostMapping()
    public String update(Customer customer){
        customerService.update(customer);
        return "redirect:/customers";
    }
}
