package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();
    void create(Product product);
    void update(Product product);
    void delete(int id);
    Product detail(int id);
    List<Product> findByName(String name);
}