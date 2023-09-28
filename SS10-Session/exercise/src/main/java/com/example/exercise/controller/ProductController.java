package com.example.exercise.controller;

import com.example.exercise.dto.CartDto;
import com.example.exercise.dto.ProductDto;
import com.example.exercise.model.Product;
import com.example.exercise.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("products")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCartDto(){
        return new CartDto();
    }
    @Autowired
    private IProductService productService;
    @GetMapping("add/{id}")
    public String addToCart(@PathVariable int id,
                            @SessionAttribute(value = "cart",required = false) CartDto cartDto){
        Product product = productService.findById(id);
        if(product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("minus/{id}")
    public String minus(@PathVariable int id,
                            @SessionAttribute(value = "cart",required = false) CartDto cartDto){
        Product product = productService.findById(id);
        if(product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cartDto.minusProductQuantity(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("delete/{id}")
    public String removeFromCart(@PathVariable int id,
                                 @SessionAttribute(value = "cart",required = false) CartDto cartDto){
        Product product = productService.findById(id);
        if(product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cartDto.deleteProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("")
    public ModelAndView showAll(){
        return new ModelAndView("product-list","productList", productService.findAll());
    }
    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable int id){
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }
}
