package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("/load/{start}/{count}")
    public ResponseEntity<List<Blog>> loadBlogs(@PathVariable int start,
                                                @PathVariable int count){
        List<Blog> blogList = blogService.loadBlogs(start,count);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList,HttpStatus.OK);
        }
    }
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Blog>> findBlogByName(@PathVariable String title){
        List<Blog> blogList = blogService.findByTitle(title);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(blogList,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(blog,HttpStatus.OK);
        }
    }
    @GetMapping("category/{id}")
    public ResponseEntity<List<Blog>> searchBlogByCategory(@PathVariable int id){
        List<Blog> blogByCategory = blogService.searchBlogByCategory(id);
        if(blogByCategory.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(blogByCategory,HttpStatus.OK);
        }
    }
}
