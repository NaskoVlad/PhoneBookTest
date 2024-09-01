package ru.netology;

import java.util.Map;
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
        AtomicReference<String> name = new AtomicReference<>();
        Runnable runnable = () -> {
            if (phonebook.containsValue(phoneNumber)){
                for(Map.Entry<String, Integer> item : phonebook.entrySet()){
                    if(item.getValue().equals(phoneNumber)){
                        name.set(String.valueOf((item.getKey())));
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        return String.valueOf(name);
    }

    public int findByName(){
        return 0;
    }
}
