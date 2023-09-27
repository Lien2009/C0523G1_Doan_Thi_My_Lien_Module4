package com.example.exercise2.repository;


import com.example.exercise2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select book.* from book\n" +
            "join orders on book.id = orders.book_id\n" +
            "where orders.code =:code",
            nativeQuery = true)
    Book findByCode(@Param("code") int code);
}
