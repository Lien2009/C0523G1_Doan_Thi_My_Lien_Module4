package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showAll();
    boolean create(Product product);
    void update(Product product);
    void delete(int id);
    Product detail(int id);
    List<Product> findByName(String name);

}
