package com.ciastek.collections.list;

import java.util.Collection;

public interface MyList {
    void add(Integer element);

    boolean remove(Integer element);

    Integer get(int index);

    int size();

    boolean isEmpty();

    boolean contains(Integer element);

    boolean addAll(Collection<Integer> collection);

    Integer set(int index, Integer element);

    void add(int index, Integer element);

    int indexOf(Integer o);

    int lastIndexOf(Integer o);
}
