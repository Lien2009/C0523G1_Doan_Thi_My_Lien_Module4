package com.example.exercise1.service;

import com.example.exercise1.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    boolean add(Blog blog);

    Blog findById(int id);

    boolean update(Blog blog);

    boolean delete(int id);
}
