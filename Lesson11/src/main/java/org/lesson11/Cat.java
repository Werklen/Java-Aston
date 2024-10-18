package org.lesson11;

public class Cat extends Animal {
    private static int catCount;
    private boolean isFull = false;

    public Cat() {
        super();
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать больше 200 м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }

    public void eat(FoodBowl bowl) {
        if (bowl.getFoodAmount() > 0) {
            bowl.decreaseFood(5); // Предположим, что коту нужно 5 еды для сытости
            isFull = true;
            System.out.println("Кот поел и теперь сыт.");
        } else {
            System.out.println("В миске недостаточно еды для кота.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }

}
