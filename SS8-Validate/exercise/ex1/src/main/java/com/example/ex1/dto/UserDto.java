package com.example.ex1.dto;

import javax.validation.constraints.*;

public class UserDto {
    private int id;
    @NotEmpty(message = "require not empty!")
    @Size(min = 5,max = 45, message = "length from 5 to 45!")
    private String firstName;
    @Size(min = 5,max = 45,message = "length from 5 to 45!")
    private String lastName;
    @Min(value = 18, message = "Over 18 years old!")
    private int age;
    @Pattern(regexp = "^0[0-9]{9}$", message = "Begin by 0 and have 10 numbers!")
    private String phoneNumber;
    @Email(message = "Not match regex!")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, int age, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
