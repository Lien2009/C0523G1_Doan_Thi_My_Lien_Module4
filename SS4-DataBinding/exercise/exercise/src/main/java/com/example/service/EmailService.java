package com.example.service;

import com.example.model.Email;
import com.example.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public Email display() {
        return emailRepository.display();
    }

    @Override
    public void update(Email email) {
        emailRepository.update(email);
    }

    @Override
    public String[] showLanguage() {
        return emailRepository.showLanguage();
    }

    @Override
    public int[] showSize() {
        return emailRepository.showSize();
    }
}
