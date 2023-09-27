package com.example.exercise2.repository;


import com.example.exercise2.model.Book;
import com.example.exercise2.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderRepository extends JpaRepository<Orders,Integer> {
}
