package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    boolean add(Category category);
    Category findById(int id);
    boolean update(Category category);
    boolean delete(int id);
}
