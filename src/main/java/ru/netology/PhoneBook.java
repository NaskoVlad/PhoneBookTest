package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, Integer> phonebook = new HashMap<>();

    public int add(String name, int phoneNumber) {
        if (!phonebook.containsKey(name)) {
            phonebook.put(name, phoneNumber);
        }
        return phonebook.size();
    }

    public String findByNumber(int phoneNumber) {
        String name = null;
        if (phonebook.containsValue(phoneNumber)) {
            for (Map.Entry<String, Integer> item : phonebook.entrySet()) {
                if (item.getValue().equals(phoneNumber)) {
                    name = item.getKey();
                }
            }
        }
        return name;
    }

    public int findByName(String name) {
        int result = 0;
        if (phonebook.containsKey(name)) {
            result = phonebook.get(name);
        }
        return result;
    }

    public void printAllNames() {
        System.out.println(phonebook.keySet());
    }
}
