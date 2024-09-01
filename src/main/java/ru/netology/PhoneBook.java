package ru.netology;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PhoneBook {
    ConcurrentHashMap<String, Integer> phonebook = new ConcurrentHashMap<>();

    public int add(String name, int phoneNumber) throws InterruptedException {
        AtomicInteger size = new AtomicInteger();
        Runnable runnable = () -> {
            if (!phonebook.containsKey(name)) {
                phonebook.put(name, phoneNumber);
            }
            size.set(phonebook.size());
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        return size.get();
    }

    public String findByNumber(int phoneNumber) throws InterruptedException {

        return null;
    }
}
