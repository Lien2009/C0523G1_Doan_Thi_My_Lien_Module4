package com.example.exercise.service;



import com.example.exercise.model.Blog;
import com.example.exercise.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;



    @Override
    public List<Blog> getList() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> searchBlogByCategory(int categoryId) {
        return blogRepository.findByCategory_Id(categoryId);
    }
}
