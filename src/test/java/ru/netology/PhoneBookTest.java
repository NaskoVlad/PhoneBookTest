package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    //Тест на добавление имя и номера
    @Test
    public void testAdd() throws InterruptedException {
        PhoneBook phoneBook = new PhoneBook();
        String name = "Елена";
        int phoneNumber = 999;
        int expected = 1;

        int result = phoneBook.add(name, phoneNumber);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindByNumber() throws InterruptedException {
        PhoneBook phoneBook = new PhoneBook();
        String name = "Елена";
        int phoneNumber = 999;
        String expected = "Елена";
        phoneBook.add(name, phoneNumber);

        String result = phoneBook.findByNumber(phoneNumber);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindByName() throws InterruptedException {
        PhoneBook phoneBook = new PhoneBook();
        String name = "Елена";
        int phoneNumber = 999;
        int expected = 999;
        phoneBook.add(name, phoneNumber);

        int result = phoneBook.findByName();

        Assertions.assertEquals(expected, result);
    }
}