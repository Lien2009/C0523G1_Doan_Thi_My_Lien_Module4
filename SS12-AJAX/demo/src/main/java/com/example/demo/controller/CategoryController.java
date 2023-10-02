package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;


    @GetMapping("categories")
    public ModelAndView findAllCategory() {
        List<Category> categoryList = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("category", "categoryList", categoryList);
        return modelAndView;
    }


    @GetMapping("categories/create")
    public String showFormCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "create-category";
    }

    @PostMapping("categories/create")
    public String createCategory(@ModelAttribute Category category,
                                 RedirectAttributes redirectAttributes) {
        categoryService.add(category);
        redirectAttributes.addFlashAttribute("message", "Thêm danh mục thành công!");
        return "redirect:/categories/create";
    }

    @GetMapping("categories/update/{id}")
    public String showFormUpdateCategory(Model model, @PathVariable int id) {
        model.addAttribute("category", categoryService.findById(id));
        return "update-category";
    }

    @PostMapping("categories/update")
    public String updateCategory(@ModelAttribute Category category,
                                 RedirectAttributes redirectAttributes) {
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("message", "Sửa danh mục thành công!");
        return "redirect:/categories/update/" + category.getId();
    }

    @GetMapping("categories/delete/{id}")
    public String deleteCategory(@PathVariable int id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/categories";
    }

    @GetMapping("categories/detail/{id}")
    public String blogsOfCategory(Model model, @PathVariable int id) {
        model.addAttribute("blogList", blogService.searchBlogByCategory(id));
        return "blog";
    }


}
