package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    //Тест на добавление имя и номера
    @Test
    public void testAdd() {
        PhoneBook phoneBook = new PhoneBook();

        String name = "Елена";
        int phoneNumber = 999;
        int expected = 1;

        int result = phoneBook.add(name, phoneNumber);

        Assertions.assertEquals(expected, result);
    }
}