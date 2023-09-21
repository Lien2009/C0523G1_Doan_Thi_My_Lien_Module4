package com.example.exercise1.controller;

import com.example.exercise1.model.Blog;
import com.example.exercise1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView findAll() {
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("list", "blogList", blogList);
        return modelAndView;
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes) {
        blogService.add(blog);
        redirectAttributes.addFlashAttribute("message", "Thêm blog thành công!");
        return "redirect:/blogs/create";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        boolean result = blogService.delete(id);
        if(result == true){
            redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Blog này không tồn tại!");
        }
        return "redirect:/blogs";
    }

    @GetMapping("update/{id}")
    public String showFormUpdate(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes) {
        boolean result = blogService.update(blog);
        if(result == true) {
            redirectAttributes.addFlashAttribute("message", "Sửa thành công!");
        }else {
            redirectAttributes.addFlashAttribute("message", "Blog này không tồn tại!");
        }
        return "redirect:/blogs/update/" + blog.getId();
    }
}
