package com.mycompany.app;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Первая задача
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два целых числа a и b:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Сравнение чисел
        if (a > b) {
            System.out.println("a > b");
        } else if (a < b) {
            System.out.println("a < b");
        } else {
            System.out.println("a = b");
        }

        // Арифметические операции
        System.out.println("Сумма a и b: " + (a + b));
        System.out.println("Разность a и b: " + (a - b));
        if (b != 0) {
            System.out.println("Деление a на b: " + ((double) a / b));
        } else {
            System.out.println("Деление на ноль невозможно");
        }
        System.out.println("Умножение a и b: " + (a * b));

        // Вторая задача
        System.out.println("Введите две строки a и b через интер:");
        scanner.nextLine(); // очистка буфера
        String strA = scanner.nextLine();
        String strB = scanner.nextLine();

        // Сравнение строк
        if (strA.equals(strB)) {
            System.out.println("Строки идентичны");
        } else {
            System.out.println("Строки неидентичны");
        }

        // Третья задача
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Чётные числа:");
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
    }
}