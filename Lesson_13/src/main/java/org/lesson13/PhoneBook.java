package org.lesson13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    // Метод для добавления записи
    public void add(String surname, String phone) {
        contacts.putIfAbsent(surname, new ArrayList<>());
        contacts.get(surname).add(phone);
    }

    // Метод для поиска телефонов по фамилии
    public List<String> get(String surname) {
        return contacts.getOrDefault(surname, new ArrayList<>());
    }
}
