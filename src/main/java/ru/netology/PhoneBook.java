package ru.netology;

import java.util.concurrent.ConcurrentHashMap;

public class PhoneBook {
    ConcurrentHashMap<String, Integer> phonebook = new ConcurrentHashMap<>();

    public int add(String name, int phoneNumber){
        if(!phonebook.containsKey(name)){
            phonebook.put(name, phoneNumber);
        }
        return phonebook.size();
    }
}
