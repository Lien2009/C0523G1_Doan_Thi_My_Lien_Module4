package com.example.demo.service;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> searchBlogByCategory(int categoryId);

    Page<Blog> findAll(Pageable pageable, String searchTitle);

    boolean add(Blog blog);

    Blog findById(int id);

    boolean update(Blog blog);

    boolean delete(int id);
}
