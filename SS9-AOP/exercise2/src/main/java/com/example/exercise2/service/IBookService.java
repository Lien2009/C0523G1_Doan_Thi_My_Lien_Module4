package com.example.exercise2.service;


import com.example.exercise2.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    boolean add(Book book);
    Book findById(int id);

}
