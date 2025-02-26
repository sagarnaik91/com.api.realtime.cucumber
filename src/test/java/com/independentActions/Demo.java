package com.independentActions;

public class Demo {
    public static void main(String[] args) {
        Developer dev = new Developer();
        Computer lap = new Laptop();
        Computer desk = new Desktop();
        dev.devApp(lap);
        dev.devApp(desk);
    }
}
