package org.lesson13;

import java.util.HashMap;
import java.util.Map;

public class UniqueWords {
    public static void main(String[] args) {
        String[] words = {
                "apple", "banana", "orange", "apple", "kiwi",
                "banana", "grape", "kiwi", "melon", "kiwi",
                "apple", "grape", "orange", "banana", "peach"
        };

        Map<String, Integer> wordCount = new HashMap<>();

        // Подсчет количества каждого слова
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Вывод уникальных слов и их количества
        System.out.println("Уникальные слова: " + wordCount.keySet());
        System.out.println("Количество каждого слова: " + wordCount.values());
    }
}
