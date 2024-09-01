package ru.netology;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("Hello world!");
        phoneBook.add("Елена", 1);
        System.out.println(phoneBook.findByNumber(1));
    }
}