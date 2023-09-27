package com.example.exercise2.service;


import com.example.exercise2.dto.RentBookDTO;
import com.example.exercise2.model.Book;
import com.example.exercise2.model.Orders;
import com.example.exercise2.repository.IBookRepository;
import com.example.exercise2.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Transactional
    @Override
    public int add(RentBookDTO rentBookDTO) throws Exception {
        Book book = bookRepository.findById(rentBookDTO.getBookId()).orElseThrow(
                () -> new IllegalArgumentException("Not found book")
        );
        if(book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
        }else {
            throw new Exception();
        }
        Orders orders = new Orders();
        orders.setName(rentBookDTO.getOrderName());
        orders.setCode((int) (Math.random() * 100000));
        orders.setBook(bookRepository.findById(rentBookDTO.getBookId()).get());
        orders = orderRepository.save(orders);
        return orders != null ? orders.getCode() : -1;
    }


}
