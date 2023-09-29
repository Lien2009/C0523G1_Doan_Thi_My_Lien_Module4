package com.example.exercise2.controller;


import com.example.exercise2.dto.RentBookDTO;
import com.example.exercise2.model.Book;
import com.example.exercise2.service.IBookService;
import com.example.exercise2.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IBookService bookService;

    @GetMapping("create/{id}")
    public String showFormCreate(Model model, @PathVariable int id) {
        RentBookDTO rentBookDTO = new RentBookDTO();
        rentBookDTO.setBookId(id);
        model.addAttribute("rentBookDTO", rentBookDTO);
        return "create-order";
    }

    @PostMapping("create")
    public String rentBook(@Valid @ModelAttribute RentBookDTO rentBookDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) throws Exception{
        if(bindingResult.hasErrors()){
            return "create-order";
        }
        int code = orderService.add(rentBookDTO);
        if(code != -1){
            redirectAttributes.addFlashAttribute("message", "Mã số mượn sách của bạn là " + code);
        }else {
            redirectAttributes.addFlashAttribute("message", "Mượn sách không thành công!");
        }
        return "redirect:/books";
    }
    @GetMapping("return")
    public String returnBook(@RequestParam int code,
                             RedirectAttributes redirectAttributes) {
        Book book = orderService.findByCode(code);
        book.setQuantity(book.getQuantity() + 1);
        bookService.add(book);
        orderService.updateOderStatus(code);
        redirectAttributes.addFlashAttribute("message", "Trả sách thành công!");
        return "redirect:/books";
    }

}
