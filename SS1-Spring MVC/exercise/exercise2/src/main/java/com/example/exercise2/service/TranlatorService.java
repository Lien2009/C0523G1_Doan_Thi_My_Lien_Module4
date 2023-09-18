package com.example.exercise2.service;

import com.example.exercise2.repository.ITranslatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exercise2.repository.TranslatorRepository;

@Service
public class TranlatorService implements ITranslatorService{
    @Autowired
    private ITranslatorRepository translatorRepository;


    @Override
    public String translate(String english) {
        String result = translatorRepository.translate(english);
        if(result == null){
            result = "Not found!";
        }
        return result;
    }
}
