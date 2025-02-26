package com.independentActions;

import org.testng.annotations.Test;

public class Task10 {
    static int ctr = 0;

    public Task10() {
        ctr++;
    }

    public static void main(String[] args) {
        Task10 a = new Task10();
        Task10 b = new Task10();
        Task10 c = new Task10();
        System.out.println(Task10.ctr);
    }


}
