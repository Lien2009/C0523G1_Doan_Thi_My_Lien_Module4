package com.example.exercise.controller;

import com.example.exercise.model.Blog;
import com.example.exercise.model.Category;
import com.example.exercise.service.IBlogService;
import com.example.exercise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/categories")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<List<Category>> getList(){
        List<Category> categoryList = categoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categoryList,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> searchBlogByCategory(@PathVariable int id){
        List<Blog> blogByCategory = blogService.searchBlogByCategory(id);
        if(blogByCategory.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(blogByCategory,HttpStatus.OK);
        }
    }
}
