package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

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

        int result = phoneBook.findByName(name);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testPrintAllNames() throws InterruptedException {
        System.setOut(new PrintStream(outputStreamCaptor));
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("C", 3);
        phoneBook.add("B", 2);
        phoneBook.add("A", 1);
        phoneBook.printAllNames();

        Assertions.assertEquals("[A, B, C]", outputStreamCaptor.toString().trim());
//        String name = "Елена";
//        int phoneNumber = 999;
//        int expected = 999;
//        phoneBook.add(name, phoneNumber);
    }

}