package com.example.exercise2.service;


import com.example.exercise2.dto.RentBookDTO;
import com.example.exercise2.model.Book;

public interface IOrderService {
    int add(RentBookDTO rentBookDTO) throws Exception;
    Book findByCode(int code);
    void updateOderStatus(int code);
}
