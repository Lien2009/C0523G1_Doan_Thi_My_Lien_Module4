package com.example.exercise2.dto;

public class RentBookDTO {

    private int bookId;

    private String orderName;

    public RentBookDTO() {
    }

    public RentBookDTO(int bookId, String customerName) {
        this.bookId = bookId;
        this.orderName = customerName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
