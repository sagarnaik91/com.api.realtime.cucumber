package com.independentActions;

import java.util.*;

public class Task18 {

    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        List<Character> llist = Collections.unmodifiableList(list);
        //llist.add('c');
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        ListIterator litr= list.listIterator(list.size());
        while (litr.hasPrevious())
        {
            System.out.println(litr.previous());
        }
    }
}
