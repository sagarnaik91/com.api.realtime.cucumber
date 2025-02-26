package com.independentActions;

public class A {
    A() {
        this("ags");
        System.out.println("constrcutor 1");
    }

    A(String a) {
        System.out.println("constructor1 with args");
    }

    public static void main(String[] args) {
        A a1 = new A();
    }
}
