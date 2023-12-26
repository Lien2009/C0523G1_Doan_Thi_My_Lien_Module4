package com.example.cs4.yard.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class YardDto implements Validator {
    private String name;
    private String address;
    private String description;
    private double price;
    private String image;

    public YardDto(String name, String address, String description, double price, String image) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public YardDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
