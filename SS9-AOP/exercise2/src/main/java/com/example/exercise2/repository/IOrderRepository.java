package com.example.exercise2.repository;


import com.example.exercise2.model.Book;
import com.example.exercise2.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "select book.* from book join orders on book.id = orders.book_id where orders.code =:code",
            nativeQuery = true)
    Book findByCode(@Param("code") int code);

    @Query(value = "update orders set status = 1 where code =:code",
    nativeQuery = true)
    void updateOderStatus(@Param("code") int code);
}
