package com.ciastek.collections.list;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;

public class MyArrayList implements MyList {
    private boolean isEmpty = true;
    private int size = 0;
    private Integer[] elements = new Integer[8];

    @Override
    public void add(Integer element) {
        elements[size] = element;
        isEmpty = false;
        size++;
    }

    @Override
    public Integer get(int index) {
        if (index < size) {
            return elements[index];
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public boolean contains(Integer element) {
        if (element == null) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Integer set(int index, Integer element) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Integer previousElement = elements[index];
        elements[index] = element;

        return previousElement;
    }

    @Override
    public int indexOf(Integer element) {
        throw new NotImplementedException();
    }

    @Override
    public int lastIndexOf(Integer element) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addAll(Collection<Integer> collection) {
        throw new NotImplementedException();
    }

    @Override
    public void add(int index, Integer element) {
        throw new NotImplementedException();
    }

    @Override
    public boolean remove(Integer element) {
        throw new NotImplementedException();
    }
}
