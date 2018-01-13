package com.ciastek.collections;

import com.ciastek.collections.list.MyArrayList;
import com.ciastek.collections.list.MyList;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyArrayList();

        list.add(5);
        System.out.println(list.get(0));
        System.out.println(list.get(20));

    }
}
