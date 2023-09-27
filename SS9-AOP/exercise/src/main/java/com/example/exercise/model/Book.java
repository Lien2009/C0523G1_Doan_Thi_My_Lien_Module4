package com.example.exercise.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    @ManyToMany
    @JoinTable(name = "customer_book",
        joinColumns = @JoinColumn(columnDefinition = "book_id",
                referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(columnDefinition = "customer_id", referencedColumnName = "id"))
    private Set<Customer> customerSet;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String name, int quantity, Set<Customer> customerSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.customerSet = customerSet;
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

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
