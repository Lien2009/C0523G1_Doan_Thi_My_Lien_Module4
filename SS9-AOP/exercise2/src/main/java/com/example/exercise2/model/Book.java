package com.example.exercise2.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private Set<Orders> orderSet;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String name, int quantity, Set<Orders> orderSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.orderSet = orderSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Orders> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Orders> orderSet) {
        this.orderSet = orderSet;
    }
}
