package com.independentActions;

public class Task12 {

    public static double pi = 3.14;
    public double radius;

    public Task12(double radius) {
        this.radius = radius;
    }

    public void getArea() {
        double area = pi * radius * radius;
        System.out.println(area);
    }

    public static void main(String[] args) {
        Task12 t12 = new Task12(2.8);
        t12.getArea();
        Task12 t13 = new Task12(6.0);
        t13.getArea();
    }
}
