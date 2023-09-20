package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView showAll() {
        List<Product> products = productService.showAll();
        ModelAndView modelAndView = new ModelAndView("list", "products", products);
        return modelAndView;
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {
        boolean result = productService.create(product);
        if (result == false) {
            redirectAttributes.addFlashAttribute("message", "SP này đã tồn tại!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm thành công!");
        }
        return "redirect:/products/create";
    }

    @GetMapping("update/{id}")
    public String showFormUpdate(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.detail(id));
        return "update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("message", "Sửa thành công!");
        return "redirect:/products/update/" + product.getId();
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.detail(id));
        return "detail";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/products";
    }

    @PostMapping("find")
    public ModelAndView find(@RequestParam String name) {
        List<Product> products = productService.findByName(name);
        ModelAndView modelAndView = new ModelAndView("find", "products", products);
        return modelAndView;
    }
}
