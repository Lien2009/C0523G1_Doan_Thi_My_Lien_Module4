package com.example.exercise.service;

import com.example.exercise.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    boolean add(Book book);
    Book findById(int id);
}
