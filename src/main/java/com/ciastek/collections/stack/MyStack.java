package com.ciastek.collections.stack;

public interface MyStack<E> {
  E push(E element);
  E pop();
  E peek();
  boolean empty();
  int search(E element);
}
