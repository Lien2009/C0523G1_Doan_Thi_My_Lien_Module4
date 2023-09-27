package com.example.exercise.controller;

import com.example.exercise.dto.RentBookDTO;
import com.example.exercise.model.Book;
import com.example.exercise.model.Customer;
import com.example.exercise.service.IBookService;
import com.example.exercise.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IBookService bookService;

    @GetMapping("create/{id}")
    public String showFormCreate(Model model, @PathVariable int id) {
//        Set<Book> bookSet = new HashSet<>();
//        bookSet.add(bookService.findById(id));
//        Customer customer = new Customer();
//        customer.setBookSet(bookSet);

        RentBookDTO rentBookDTO = new RentBookDTO();
        rentBookDTO.setBookId(id);
        model.addAttribute("rentBookDTO", rentBookDTO);
        return "create-customer";
    }

    @PostMapping("create")
    public String create(@ModelAttribute RentBookDTO rentBookDTO,
                         RedirectAttributes redirectAttributes) {
        int code = customerService.add(rentBookDTO);

        // TODO if code = -1
        redirectAttributes.addFlashAttribute("message", "Mã số mượn sách của bạn là " + code);
        return "redirect:/books";
    }


}
