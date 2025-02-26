package com.independentActions;

public class Task15 extends Task14{

    public void getArea(int a, int b, int c,int d)
    {
        System.out.println("Overloaded method of subclass");
    }

    public static void main(String[] args) {
        Task15 t15 = new Task15();
        t15.getArea(2,3,4,8);
        t15.doArea();
        Task14 t14 = new Task14();
        t14.getArea(3,2,4);
    }
}
