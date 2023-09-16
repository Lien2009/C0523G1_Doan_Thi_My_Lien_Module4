package com.example.practice2.service;

import com.example.practice2.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer findById(int id);
    void update(Customer customer);
}
