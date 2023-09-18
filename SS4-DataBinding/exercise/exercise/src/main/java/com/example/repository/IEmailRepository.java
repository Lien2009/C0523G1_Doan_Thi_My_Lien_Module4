package com.example.repository;

import com.example.model.Email;

import java.util.List;

public interface IEmailRepository {
    Email display();
    void update(Email newEmail);
    String[] showLanguage();
    int[] showSize();
}
