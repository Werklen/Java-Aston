package org.lesson11;

interface Shape {
    double calculateArea();

    double calculatePerimeter();

    default void displayInfo() {
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }

    void setFillColor(String fillColor);

    void setBorderColor(String borderColor);

    String getFillColor();

    String getBorderColor();
}


