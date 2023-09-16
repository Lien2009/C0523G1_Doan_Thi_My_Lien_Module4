package com.example.practice2.repository;

import com.example.practice2.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();
    Customer findById(int id);
    void update(Customer customer);
}
