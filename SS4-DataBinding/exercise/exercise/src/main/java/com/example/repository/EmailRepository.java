package com.example.repository;

import com.example.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private String[] languageList = {"English","Vietnamese","Japanese","Chinese"};
    private int[] sizeList = {5, 10, 15, 25, 50, 100};
    private Email email = new Email("English", 5, true, "Lien");

    @Override
    public Email display() {
        return email;
    }

    @Override
    public void update(Email newEmail) {
        email = newEmail;
    }

    @Override
    public String[] showLanguage() {
        return languageList;
    }

    @Override
    public int[] showSize() {
        return sizeList;
    }
}
