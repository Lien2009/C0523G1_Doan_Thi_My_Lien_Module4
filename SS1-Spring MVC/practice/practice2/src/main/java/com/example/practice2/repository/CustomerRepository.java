package com.example.practice2.repository;

import com.example.practice2.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Lien","lien@gmail.com","Da Nang"));
        customerList.add(new Customer(2,"Hanh","hanh@gmail.com","Quang Nam "));
        customerList.add(new Customer(3,"Thien","thien@gmail.com","Hoi An"));
        customerList.add(new Customer(4,"Hung","hung@gmail.com","Quang Binh"));
    }
    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}
