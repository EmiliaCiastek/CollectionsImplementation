package com.ciastek.collections.stack;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.EmptyStackException;

public class MyStackImpl implements MyStack {
  private Node top;
  private boolean isEmpty = true;

  @Override
  public String push(String element) {
    if (isEmpty) {
      top = new Node(element);
    } else {
      top = new Node(element, top);
    }

    isEmpty = false;
    return element;
  }

  @Override
  public String pop() {
    if (isEmpty) {
      throw new EmptyStackException();
    }

    Node currentTop = top;
    top = currentTop.previousNode;
    isEmpty = top == null;

    return currentTop.nodeValue;
  }

  @Override
  public String peek() {
    if (isEmpty) {
      throw new EmptyStackException();
    }

    return top.nodeValue;
  }

  @Override
  public boolean empty() {
    return isEmpty;
  }

  @Override
  public int search(String element) {
    if(element.equals(top.nodeValue)){
      return 1;
    }

    throw new NotImplementedException();
  }

  private class Node {
    private String nodeValue;
    private Node previousNode;

    Node(String nodeValue, Node previousNode) {
      this.nodeValue = nodeValue;
      this.previousNode = previousNode;
    }

    Node(String nodeValue) {
      this(nodeValue, null);
    }
  }
}
