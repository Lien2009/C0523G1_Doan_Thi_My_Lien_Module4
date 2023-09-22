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

    @GetMapping("blogs")
    public ModelAndView findAllBlog(@RequestParam(defaultValue = "0", required = false) int page,
                                    @RequestParam(defaultValue = "", required = false) String searchTitle) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("time").descending());
        Page<Blog> blogPage = blogService.findAll(pageable, searchTitle);
        ModelAndView modelAndView = new ModelAndView("list", "blogPage", blogPage);
        modelAndView.addObject("searchTitle", searchTitle);
        return modelAndView;
    }

    @GetMapping("blogs/create")
    public String showFormCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());
        return "create";
    }

    @PostMapping("blogs/create")
    public String create(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes) {
        blogService.add(blog);
        redirectAttributes.addFlashAttribute("message", "Thêm blog thành công!");
        return "redirect:/blogs/create";
    }

    @GetMapping("blogs/detail/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }

    @GetMapping("blogs/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        boolean result = blogService.delete(id);
        if (result == true) {
            redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Blog này không tồn tại!");
        }
        return "redirect:/blogs";
    }

    @GetMapping("blogs/update/{id}")
    public String showFormUpdate(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "update";
    }

    @PostMapping("blogs/update")
    public String update(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes) {
        boolean result = blogService.update(blog);
        if (result == true) {
            redirectAttributes.addFlashAttribute("message", "Sửa thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Blog này không tồn tại!");
        }
        return "redirect:/blogs/update/" + blog.getId();
    }
}
