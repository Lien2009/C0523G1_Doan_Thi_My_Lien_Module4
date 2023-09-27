package com.example.exercise.controller;

import com.example.exercise.model.Book;
import com.example.exercise.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping("")
    public ModelAndView showAll(){
        List<Book> bookList = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("list-book","bookList",bookList);
        return modelAndView;
    }
    @GetMapping("create")
    public String showFormCreate(Model model){
        model.addAttribute("book", new Book());
        return "create-book";
    }
    @PostMapping("create")
    public String save(@ModelAttribute Book book,
                       RedirectAttributes redirectAttributes){
        bookService.add(book);
        redirectAttributes.addFlashAttribute("message", "Thêm sách thành công!");
        return "redirect:/books/create";
    }
}
