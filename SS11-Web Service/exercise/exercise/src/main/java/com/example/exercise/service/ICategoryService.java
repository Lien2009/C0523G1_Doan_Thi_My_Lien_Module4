package com.example.exercise.service;



import com.example.exercise.model.Blog;
import com.example.exercise.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

}
