package com.example.ex1.service;

import com.example.ex1.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean add(User user);
}
