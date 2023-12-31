package com.example.exercise2.controller;


import com.example.exercise2.model.Book;
import com.example.exercise2.service.IBookService;
import com.example.exercise2.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService orderService;

    @GetMapping("")
    public ModelAndView showAll() {
        List<Book> bookList = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("list-book", "bookList", bookList);
        return modelAndView;
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("book", new Book());
        return "create-book";
    }

    @PostMapping("create")
    public String saveBook(@ModelAttribute Book book,
                           RedirectAttributes redirectAttributes) {
        bookService.add(book);
        redirectAttributes.addFlashAttribute("message", "Thêm sách thành công!");
        return "redirect:/books/create";
    }


}
