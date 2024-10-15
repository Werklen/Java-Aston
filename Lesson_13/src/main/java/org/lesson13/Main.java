package org.lesson13;
public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Иванов", "789-012");
        phoneBook.add("Петров", "345-678");
        phoneBook.add("Сидоров", "901-234");

        // Поиск телефонов по фамилии
        System.out.println("Телефоны Иванова: " + phoneBook.get("Иванов")); // ["123-456", "789-012"]
        System.out.println("Телефоны Петрова: " + phoneBook.get("Петров")); // ["345-678"]
        System.out.println("Телефоны Сидорова: " + phoneBook.get("Сидоров")); // ["901-234"]
        System.out.println("Телефоны Смирнова: " + phoneBook.get("Смирнов")); // []
    }
}