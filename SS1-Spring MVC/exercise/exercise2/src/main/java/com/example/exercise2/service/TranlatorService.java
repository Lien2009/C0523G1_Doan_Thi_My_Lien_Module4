package com.example.exercise2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exercise2.repository.TranslatorRepository;

@Service
public class TranlatorService {
    @Autowired
    private TranslatorRepository translatorRepository;

    public String find(String english) {
        return translatorRepository.find(english);
    }
}
