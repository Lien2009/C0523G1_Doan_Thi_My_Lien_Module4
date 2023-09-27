package com.example.exercise2.controller;


import com.example.exercise2.dto.RentBookDTO;
import com.example.exercise2.service.IBookService;
import com.example.exercise2.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String rentBook(@ModelAttribute RentBookDTO rentBookDTO,
                           RedirectAttributes redirectAttributes) throws Exception{
        int code = orderService.add(rentBookDTO);
        if(code == -1){
            redirectAttributes.addFlashAttribute("message", "Mượn sách không thành công!");
        }else {
            redirectAttributes.addFlashAttribute("message", "Mã số mượn sách của bạn là " + code);
        }
        return "redirect:/books";
    }


}
