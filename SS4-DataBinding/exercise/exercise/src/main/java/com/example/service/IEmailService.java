package com.example.service;

import com.example.model.Email;

public interface IEmailService {
    Email display();
    void update(Email email);
    String[] showLanguage();
    int[] showSize();
}
