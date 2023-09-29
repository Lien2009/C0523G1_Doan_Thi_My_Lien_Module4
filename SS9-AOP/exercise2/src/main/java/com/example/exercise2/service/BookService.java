package com.example.exercise2.service;


import com.example.exercise2.model.Book;
import com.example.exercise2.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public boolean add(Book book) {
        Book book1 = bookRepository.save(book);
        return book1 != null;
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }


}
