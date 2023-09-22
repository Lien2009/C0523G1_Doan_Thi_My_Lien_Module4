package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean add(Category category) {
        Category category1 = categoryRepository.save(category);
        return category1!=null;
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public boolean update(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public boolean delete(int id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
