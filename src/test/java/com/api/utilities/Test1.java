package com.api.utilities;

public class Test1 {
    public static boolean test1(int num) {
        boolean flag = false;
        int m = num / 2;
        for (int i = 2; i <= m; i++) {
            if (num % i == 0) {
                //System.out.println("It is not a prime");
            } else {
                //System.out.println("It is a prime");
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(test1(7));
        //test1(7);
    }
}
