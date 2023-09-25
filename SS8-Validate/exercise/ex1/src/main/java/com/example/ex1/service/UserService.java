package com.example.ex1.service;

import com.example.ex1.model.User;
import com.example.ex1.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements  IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean add(User user) {
        User user1 = userRepository.save(user);
        return user1!=null;
    }
}
