package com.ciastek.collections.list;

public class MyArrayList implements MyList {
    private final static int INITIAL_SIZE = 5;
    private Integer[] elements = new Integer[INITIAL_SIZE];
    private int currentIndex = 0;

    public void add(Integer element) {
        elements[currentIndex] = element;
        currentIndex++;
    }

    public Integer get(int index) {
        return elements[index];
    }
}
