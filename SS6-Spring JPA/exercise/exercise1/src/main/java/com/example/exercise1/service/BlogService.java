package com.example.exercise1.service;

import com.example.exercise1.model.Blog;
import com.example.exercise1.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public boolean add(Blog blog) {
        Blog blog1 = blogRepository.save(blog);
        return blog1!=null;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public boolean update(Blog blog) {
        if(findById(blog.getId()) == null){
            return false;
        } else {
            blogRepository.save(blog);
            return true;
        }
    }

    @Override
    public boolean delete(int id) {
        if(findById(id) == null){
            return false;
        } else {
            blogRepository.deleteById(id);
            return true;
        }
    }
}
