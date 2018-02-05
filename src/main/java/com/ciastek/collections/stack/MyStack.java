package com.ciastek.collections.stack;

public interface MyStack {
  String push(String element);
  String pop();
  String peek();
  boolean empty();
  int search(String element);
}
