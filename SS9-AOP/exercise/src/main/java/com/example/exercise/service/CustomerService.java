package com.example.exercise.service;

import com.example.exercise.dto.RentBookDTO;
import com.example.exercise.model.Book;
import com.example.exercise.model.Customer;
import com.example.exercise.repository.IBookRepository;
import com.example.exercise.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Transactional
    @Override
    public int add(RentBookDTO rentBookDTO) {
        Book book = bookRepository.findById(rentBookDTO.getBookId()).orElseThrow(
                () -> new IllegalArgumentException("Not found book")
        );
        book.setQuantity(book.getQuantity() - 1);
        Customer customer = new Customer();
        customer.setName(rentBookDTO.getCustomerName());
        customer.setCode((int) (Math.random() * 90000) + 10000);
        customer = customerRepository.save(customer);
        book = bookRepository.save(book);
        if (book.getCustomerSet() != null) {
            book.getCustomerSet().add(customer);
        } else {
            Set<Customer> customers = new HashSet<>();
            customers.add(customer);
            book.setCustomerSet(customers);
        }
        return customer != null ? customer.getCode() : -1;
    }
}
