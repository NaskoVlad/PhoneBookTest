package ru.netology;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.String.*;

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
        AtomicReference<String> name1 = new AtomicReference<>("");
        Runnable runnable = () -> {
            phonebook.searchKeys(10, s -> {
                if (phonebook.containsValue(phoneNumber)) {
                    for (Map.Entry<String, Integer> item : phonebook.entrySet()) {
                        if (item.getValue().equals(phoneNumber)) {
                            name1.set(valueOf((item.getKey())));
                        }
                    }
                }
                return name1.get();
            });
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        return name1.get();
    }

    public int findByName(String name) throws InterruptedException {
        AtomicInteger result = new AtomicInteger();
        Runnable runnable = () -> {
            if (phonebook.containsKey(name)) {
                result.set(phonebook.get(name));
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        return result.get();
    }

    public void printAllNames() {
        System.out.println(phonebook.keySet());
    }
}
