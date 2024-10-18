package org.lesson11;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.run(300);
        dog1.swim(5);

        Cat cat1 = new Cat();
        cat1.run(150);
        cat1.swim(5);

        FoodBowl bowl = new FoodBowl(10);

        Cat[] cats = {new Cat(), new Cat(), new Cat()};

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + " сытый: " + cats[i].isFull());
        }

        bowl.addFood(10);
        System.out.println("Добавим еды в количестве: " + bowl.getFoodAmount());

        System.out.println("Общее количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println("Количество котов: " + Cat.getCatCount());


        Shape circle = new Circle(5, "Красный", "Черный");
        Shape rectangle = new Rectangle(4, 6, "Синий", "Зеленый");
        Shape triangle = new Triangle(3, 4, 5, "Желтый", "Фиолетовый");

        System.out.println("Круг:");
        circle.displayInfo();

        System.out.println("nПрямоугольник:");
        rectangle.displayInfo();

        System.out.println("nТреугольник:");
        triangle.displayInfo();

    }
}