package com.example.exercise2.model;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "code", unique = true)
    private int code;
    private String name;
    @Column(columnDefinition = "boolean default false")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Orders() {
    }

    public Orders(int id, int code, String name, Book book) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.book = book;
    }

    public Orders(int id, int code, String name, boolean status, Book book) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.status = status;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
