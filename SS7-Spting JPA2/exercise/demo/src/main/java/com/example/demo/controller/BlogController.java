package com.example.demo.controller;

import com.example.demo.model.Blog;
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

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
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
