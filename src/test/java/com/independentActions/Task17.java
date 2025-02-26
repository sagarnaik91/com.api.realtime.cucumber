package com.independentActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task17 {
    public static void main(String[] args) {
        String[] arr = {"df", "we", "qw"};
        List a = Arrays.asList(arr);
        System.out.println(a);

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        Object[] obj=list.toArray();
        for (Object o:obj)
        {
            System.out.println(o);
        }

    }
    //Array is fix
}
