package com.independentActions;

public class Task11 {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Task11 t11 = new Task11();
        t11.setName("John");
        System.out.println(t11.getName());
        Task11 t12 = new Task11();
        t12.setName("Donald");
        System.out.println(t12.getName());
    }
}
