package com.example.exercise2.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TranslatorRepository {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("one", "một");
        dictionary.put("two", "hai");
        dictionary.put("three", "ba");
        dictionary.put("four", "bốn");
        dictionary.put("five", "năm");
        dictionary.put("six", "sáu");
    }

    public String find(String english) {
        String result = null;
        if(dictionary.containsKey(english)){
            result = dictionary.get(english);
        } else {
            result = "Not found";
        }
        return result;
    }
}
